package com.equalinformation.shipping.poc.pi.data;

import com.equalinformation.shipping.poc.pi.domain.ShippingNotification;
import com.equalinformation.shipping.poc.pi.domain.User;

import java.util.Collection;

/**
 * Created by bpupadhyaya on 12/27/15.
 */
public interface DataProvider {
    //TODO

    /**
     * @return The number of unread notifications for the current user.
     */
    int getUnreadNotificationsCount();

    /**
     * @param userName
     * @param password
     * @return Authenticated used.
     */
    User authenticate(String userName, String password);

    /**
     * @return Notifications for the current user.
     */
    Collection<ShippingNotification> getNotifications();
}
