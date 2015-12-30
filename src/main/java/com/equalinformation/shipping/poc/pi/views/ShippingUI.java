package com.equalinformation.shipping.poc.pi.views;

import com.equalinformation.shipping.poc.pi.data.DataProvider;
import com.equalinformation.shipping.poc.pi.data.dummy.DummyDataProvider;
import com.equalinformation.shipping.poc.pi.domain.User;
import com.equalinformation.shipping.poc.pi.event.ShippingEvent;
import com.equalinformation.shipping.poc.pi.event.ShippingEventBus;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.*;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;

import javax.servlet.annotation.WebServlet;
import java.util.Locale;

/**
 * Created by bpupadhyaya on 12/23/15.
 */

@Theme("mytheme")
@Widgetset("com.equalinformation.shipping.poc.pi.MyAppWidgetset")
@Title("Shipping App")
public class ShippingUI extends UI {

    @WebServlet(urlPatterns = "/*", name = "ShippingUIMainServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = ShippingUI.class, productionMode = false)
    public static class ShippingUIMainServlet extends VaadinServlet {
    }

    private final DataProvider dataProvider = new DummyDataProvider();
    private final ShippingEventBus shippingEventBus = new ShippingEventBus();

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setLocale(Locale.US);
        ShippingEventBus.register(this);
        Responsive.makeResponsive(this);
        addStyleName(ValoTheme.UI_WITH_MENU);

        updateContent();

        //Browser re-size event gets fired on every browser re-resize
        Page.getCurrent().addBrowserWindowResizeListener(
                new Page.BrowserWindowResizeListener() {
                    @Override
                    public void browserWindowResized(final Page.BrowserWindowResizeEvent browserWindowResizeEvent) {
                        ShippingEventBus.post(new ShippingEvent.BrowserResizeEvent());

                    }
                }
        );
    }

    /**
     * Correct content for this UI based on current user status --- logged in or logged out
     */
    private void updateContent() {
        User user = (User) VaadinSession.getCurrent().getAttribute(
                User.class.getName());
        if (user != null && "admin".equals(user.getRole())) {
            // Authenticated user
            setContent(new MainView());
            removeStyleName("loginview");
            getNavigator().navigateTo(getNavigator().getState());
        } else {
            setContent(new LoginView());
            addStyleName("loginview");
        }
    }

    /**
     * @return An instance for accessing the (dummy) services layer.
     */
    public static DataProvider getDataProvider() {
        return ((ShippingUI) getCurrent()).dataProvider;
    }

    public static ShippingEventBus getShippingEventbus() {
        return ((ShippingUI) getCurrent()).shippingEventBus;
    }

}
