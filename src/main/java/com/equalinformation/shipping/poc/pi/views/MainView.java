package com.equalinformation.shipping.poc.pi.views;

import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by bpupadhyaya on 12/28/15.
 */
public class MainView extends HorizontalLayout {
    public MainView() {
        setSizeFull();
        addStyleName("mainview");

        addComponent(new ShippingMenu());

        ComponentContainer content = new CssLayout();
        content.addStyleName("view-content");
        content.setSizeFull();
        addComponent(content);
        setExpandRatio(content, 1.0f);

        new ShippingNavigator(content);
    }
}
