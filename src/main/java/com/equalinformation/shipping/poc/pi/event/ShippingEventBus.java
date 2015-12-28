package com.equalinformation.shipping.poc.pi.event;

import com.equalinformation.shipping.poc.pi.views.ShippingUI;
import com.google.gwt.thirdparty.guava.common.eventbus.EventBus;
import com.google.gwt.thirdparty.guava.common.eventbus.SubscriberExceptionContext;
import com.google.gwt.thirdparty.guava.common.eventbus.SubscriberExceptionHandler;

/**
 * Created by bpupadhyaya on 12/27/15.
 */
public class ShippingEventBus implements SubscriberExceptionHandler {

    private final EventBus eventBus = new EventBus(this);

    public static void post(final Object event) {
        ShippingUI.getShippingEventbus().eventBus.post(event);
    }

    public static void register(final Object object) {
        ShippingUI.getShippingEventbus().eventBus.register(object);
    }

    public static void unregister(final Object object) {
        ShippingUI.getShippingEventbus().eventBus.unregister(object);
    }

    @Override
    public void handleException(Throwable throwable, SubscriberExceptionContext subscriberExceptionContext) {
        throwable.printStackTrace();
    }
}
