package org.delta.notification.persons;

public class NotifyCustomerEvent {

    private NotifyCustomerData notificationData;

    public NotifyCustomerEvent(String customerName) {
        notificationData = new NotifyCustomerData(customerName);
    }
    public NotifyCustomerData getNotificationData() {
        return notificationData;
    }
}
