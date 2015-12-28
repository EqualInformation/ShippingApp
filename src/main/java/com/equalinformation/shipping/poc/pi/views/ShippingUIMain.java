package com.equalinformation.shipping.poc.pi.views;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import javax.servlet.annotation.WebServlet;

/**
 * Created by bpupadhyaya on 12/23/15.
 */

@Theme("mytheme")
@Widgetset("com.equalinformation.shipping.poc.pi.MyAppWidgetset")
@Title("Shipping App")
public class ShippingUIMain extends UI {

    @WebServlet(urlPatterns = "/*", name = "ShippingUIMainServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ShippingUIMain.class, productionMode = false)
    public static class ShippingUIMainServlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);

        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
            }
        });
        layout.addComponent(button);

    }

}
