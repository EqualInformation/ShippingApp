package org.vaadin.maddon;

/**
 * Created by bpupadhyaya on 1/4/16.
 */

import com.vaadin.data.Container;
import com.vaadin.data.Item;
import com.vaadin.data.Property;
import com.vaadin.data.util.AbstractContainer;
import org.apache.commons.beanutils.*;
import org.apache.commons.collections.comparators.NullComparator;
import org.apache.commons.collections.comparators.ReverseComparator;
import org.apache.commons.lang3.ClassUtils;

import java.util.*;

/**
 * A replacement for BeanItemContainer from the core
 * <p>
 * The ListContainer is rather similar to the cores BeanItemContainer, but has
 * better typed API, much smaller memory overhead (practically no overhead if
 * data is given as List) and also otherwise better performance.
 *
 * @param <T> the type of beans in the backed list
 */
public class ListContainer<T> extends AbstractContainer implements
        Container.Indexed, Container.Sortable, Container.ItemSetChangeNotifier {

    private List<T> backingList;

    public ListContainer(Collection<T> backingList) {
        setCollection(backingList);
    }

    public ListContainer(Class<T> type, Collection<T> backingList) {
        dynaClass = WrapDynaClass.createDynaClass(type);
        setCollection(backingList);
    }

    public final void setCollection(Collection<T> backingList1) {
        if (backingList1 instanceof List) {
            this.backingList = (List<T>) backingList1;
        } else {
            this.backingList = new ArrayList<T>(backingList1);
        }
        fireItemSetChange();
    }

    public ListContainer(Class<T> type) {
        backingList = new ArrayList<T>();
        dynaClass = WrapDynaClass.createDynaClass(type);
    }

    protected List<T> getBackingList() {
        return backingList;
    }

    private transient WrapDynaClass dynaClass;

    private WrapDynaClass getDynaClass() {
        if (dynaClass == null && !backingList.isEmpty()) {
            dynaClass = WrapDynaClass.createDynaClass(backingList.get(0).
                    getClass());
        }
        return dynaClass;
    }

    @Override
    public int indexOfId(Object itemId) {
        return getBackingList().indexOf(itemId);
    }

    public int indexOf(T bean) {
        return indexOfId(bean);
    }

    @Override
    public T getIdByIndex(int index) {
        return getBackingList().get(index);
    }

    @Override
    public List<T> getItemIds(int startIndex, int numberOfItems) {
        return getBackingList().subList(startIndex, startIndex + numberOfItems);
    }

    @Override
    public Object addItemAt(int index) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Item addItemAt(int index, Object newItemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public T nextItemId(Object itemId) {
        int i = getBackingList().indexOf(itemId) + 1;
        if(getBackingList().size() == i) {
            return null;
        }
        return getBackingList().get(i);
    }

    @Override
    public T prevItemId(Object itemId) {
        int i = getBackingList().indexOf(itemId) -1;
        if(i < 0) {
            return null;
        }
        return getBackingList().get(i);
    }

    @Override
    public T firstItemId() {
        return (getBackingList().isEmpty())? null : getBackingList().get(0);
    }

    @Override
    public T lastItemId() {
        return getBackingList().isEmpty()? null : getBackingList().get(getBackingList().size() - 1);
    }

    @Override
    public boolean isFirstId(Object itemId) {
        return itemId.equals(firstItemId());
    }

    @Override
    public boolean isLastId(Object itemId) {
        return itemId.equals(lastItemId());
    }

    @Override
    public Object addItemAfter(Object previousItemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Item addItemAfter(Object previousItemId, Object newItemId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Item getItem(Object itemId) {
        if (itemId == null) {
            return null;
        }
        return new DynaBeanItem<T>((T) itemId);
    }

    @Override
    public Collection<String> getContainerPropertyIds() {
        ArrayList<String> properties = new ArrayList<String>();
        if (getDynaClass() != null) {
            for (DynaProperty db : getDynaClass().getDynaProperties()) {
                properties.add(db.getName());
            }
            properties.remove("class");
        }
        return properties;
    }

    @Override
    public Collection<?> getItemIds() {
        return getBackingList();
    }

    @Override
    public Property getContainerProperty(Object itemId, Object propertyId) {
        return getItem(itemId).getItemProperty(propertyId);
    }

    @Override
    public Class<?> getType(Object propertyId) {
        final Class<?> type = getDynaClass().getDynaProperty(propertyId.toString()).getType();
        if(type.isPrimitive()) {
            // Vaadin can't handle primitive types in _all_ places, so use
            // wrappers instead. FieldGroup works, but e.g. Table in _editable_
            // mode fails for some reason
            return ClassUtils.primitiveToWrapper(type);
        }
        return type;
    }

    @Override
    public int size() {
        return getBackingList().size();
    }

    @Override
    public boolean containsId(Object itemId) {
        return getBackingList().contains((T) itemId);
    }

    @Override
    public Item addItem(Object itemId) throws UnsupportedOperationException {
        backingList.add((T) itemId);
        fireItemSetChange();
        return getItem(itemId);
    }

    @Override
    public Object addItem() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeItem(Object itemId) throws UnsupportedOperationException {
        final boolean remove = backingList.remove((T) itemId);
        if (remove) {
            fireItemSetChange();
        }
        return remove;
    }

    @Override
    public boolean addContainerProperty(Object propertyId,
                                        Class<?> type, Object defaultValue) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeContainerProperty(Object propertyId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean removeAllItems() throws UnsupportedOperationException {
        backingList.clear();
        fireItemSetChange();
        return true;
    }

    public ListContainer addAll(Collection<T> beans) {
        backingList.addAll(beans);
        fireItemSetChange();
        return this;
    }

    @Override
    public void sort(Object[] propertyId, boolean[] ascending) {
        Comparator c = new NullComparator();
        if (!ascending[0]) {
            c = new ReverseComparator(c);
        }
        BeanComparator<T> bc = new BeanComparator<T>(propertyId[0].toString(), c);
        Collections.sort(backingList, bc);
    }

    @Override
    public Collection<?> getSortableContainerPropertyIds() {
        ArrayList<String> properties = new ArrayList<String>();
        for (DynaProperty db : getDynaClass().getDynaProperties()) {
            if (db.getType().isPrimitive() || Comparable.class.isAssignableFrom(
                    db.getType())) {
                properties.add(db.getName());
            }
        }
        properties.remove("class");
        return properties;
    }

    public void addItemSetChangeListener(
            ItemSetChangeListener listener) {
        super.addItemSetChangeListener(listener);
    }

    public void removeItemSetChangeListener(
            ItemSetChangeListener listener) {
        super.removeItemSetChangeListener(listener);
    }

    public void addListener(ItemSetChangeListener listener) {
        super.addListener(listener);
    }

    public void removeListener(ItemSetChangeListener listener) {
        super.removeListener(listener);
    }

    public class DynaBeanItem<T> implements Item {

        private Map<Object, DynaProperty> propertyIdToProperty = new HashMap<Object, DynaProperty>();

        private class DynaProperty implements Property {

            private final String propertyName;

            public DynaProperty(String property) {
                propertyName = property;
            }

            @Override
            public Object getValue() {
                return getDynaBean().get(propertyName);
            }

            @Override
            public void setValue(Object newValue) throws ReadOnlyException {
                getDynaBean().set(propertyName, newValue);
            }

            @Override
            public Class getType() {
                return ListContainer.this.getType(propertyName);
            }

            @Override
            public boolean isReadOnly() {
                return getDynaClass().getPropertyDescriptor(propertyName).
                        getWriteMethod() == null;
            }

            @Override
            public void setReadOnly(boolean newStatus) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        }

        private T bean;

        private transient DynaBean db;

        public DynaBeanItem(T bean) {
            this.bean = bean;
        }

        private DynaBean getDynaBean() {
            if (db == null) {
                db = new WrapDynaBean(bean);
            }
            return db;
        }

        @Override
        public Property getItemProperty(Object id) {
            DynaProperty prop = propertyIdToProperty.get(id);
            if (prop == null) {
                prop = new DynaProperty(id.toString());
                propertyIdToProperty.put(id, prop);
            }
            return prop;
        }

        @Override
        public Collection<String> getItemPropertyIds() {
            return ListContainer.this.getContainerPropertyIds();
        }

        @Override
        public boolean addItemProperty(Object id, Property property) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public boolean removeItemProperty(Object id) throws UnsupportedOperationException {
            throw new UnsupportedOperationException("Not supported yet.");
        }

    }

}
