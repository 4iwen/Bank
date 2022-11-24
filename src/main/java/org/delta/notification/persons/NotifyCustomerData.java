package org.delta.notification.persons;

import javax.inject.Inject;

public class NotifyCustomerData {

    private String customerName;

    public NotifyCustomerData(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }
}
