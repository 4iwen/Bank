package org.delta.notification.persons;

import com.google.common.eventbus.Subscribe;

import javax.inject.Singleton;

@Singleton
public class NotifyCustomerEventListener {
    @Subscribe
    public void notifyCustomer(NotifyCustomerEvent event) {
        System.out.println("Call event: " + event.getNotificationData().getCustomerName());
    }
}
