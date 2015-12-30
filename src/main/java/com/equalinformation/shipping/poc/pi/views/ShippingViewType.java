package com.equalinformation.shipping.poc.pi.views;

import com.equalinformation.shipping.poc.pi.views.view1.View1View;
import com.equalinformation.shipping.poc.pi.views.view2.View2View;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;

/**
 * Created by bpupadhyaya on 12/28/15.
 */
public enum ShippingViewType {
    VIEW1("view1", View1View.class, FontAwesome.HOME, true),
    VIEW2("view2", View2View.class, FontAwesome.BAR_CHART_O, false);
//    TRANSACTIONS("view3", View3View.class, FontAwesome.TABLE, false), //TODO add later
//    REPORTS("view4", View4View.class, FontAwesome.FILE_TEXT_O, true), //TODO add later
//    SCHEDULE("view5", View4View.class, FontAwesome.CALENDAR_O, false); //TODO add later

    private final String viewName;
    private final Class<? extends View> viewClass;
    private final Resource icon;
    private final boolean stateful;

    private ShippingViewType(final String viewName,
                              final Class<? extends View> viewClass, final Resource icon,
                              final boolean stateful) {
        this.viewName = viewName;
        this.viewClass = viewClass;
        this.icon = icon;
        this.stateful = stateful;
    }

    public boolean isStateful() {
        return stateful;
    }

    public String getViewName() {
        return viewName;
    }

    public Class<? extends View> getViewClass() {
        return viewClass;
    }

    public Resource getIcon() {
        return icon;
    }

    public static ShippingViewType getByViewName(final String viewName) {
        ShippingViewType result = null;
        for (ShippingViewType viewType : values()) {
            if (viewType.getViewName().equals(viewName)) {
                result = viewType;
                break;
            }
        }
        return result;
    }
}
