package com.equalinformation.shipping.poc.pi.views.view1;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Panel;

/**
 * Created by bpupadhyaya on 12/29/15.
 */
public class View1View extends Panel implements View, View1Edit.ShippingEditListener {

    @Override
    public void shippingNameEdited(String name) {
        //TODO
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        //TODO
    }
}
