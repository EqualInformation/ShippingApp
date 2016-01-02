package com.equalinformation.shipping.poc.pi.data.dummy;

import com.equalinformation.shipping.poc.pi.data.DataProvider;
import com.equalinformation.shipping.poc.pi.domain.ShippingNotification;
import com.equalinformation.shipping.poc.pi.domain.User;
import com.google.gwt.thirdparty.guava.common.base.Predicate;
import com.google.gwt.thirdparty.guava.common.collect.Collections2;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by bpupadhyaya on 12/27/15.
 */
public class DummyDataProvider implements DataProvider {
    //TODO

    private final Collection<ShippingNotification> notifications = DummyDataGenerator.randomNotifications();

    @Override
    public int getUnreadNotificationsCount() {
        Predicate<ShippingNotification> unreadPredicate = new Predicate<ShippingNotification>() {
            @Override
            public boolean apply(ShippingNotification input) {
                return !input.isRead();
            }
        };
        return Collections2.filter(notifications, unreadPredicate).size();
    }

    @Override
    public User authenticate(String userName, String password) {
        User user = new User();
        user.setFirstName(DummyDataGenerator.randomFirstName());
        user.setLastName(DummyDataGenerator.randomLastName());
        user.setRole("admin");
        String email = user.getFirstName().toLowerCase() + "."
                + user.getLastName().toLowerCase() + "@"
                + DummyDataGenerator.randomCompanyName().toLowerCase() + ".com";
        user.setEmail(email.replaceAll(" ", ""));
        user.setLocation(DummyDataGenerator.randomWord(5, true));
        user.setBio("Quis aute iure reprehenderit in voluptate velit esse."
                + "Cras mattis iudicium purus sit amet fermentum.");
        return user;
    }

    @Override
    public Collection<ShippingNotification> getNotifications() {
        for (ShippingNotification notification : notifications) {
            notification.setRead(true);
        }
        return Collections.unmodifiableCollection(notifications);
    }


}
