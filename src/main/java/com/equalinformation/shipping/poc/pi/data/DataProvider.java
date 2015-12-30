package com.equalinformation.shipping.poc.pi.data;

/**
 * Created by bpupadhyaya on 12/27/15.
 */
public interface DataProvider {
    //TODO

    /**
     * @return The number of unread notifications for the current user.
     */
    int getUnreadNotificationsCount();
}
