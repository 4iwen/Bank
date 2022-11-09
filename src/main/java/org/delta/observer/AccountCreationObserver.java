package org.delta.observer;

public class AccountCreationObserver implements Observer {
    public void update() {
        System.out.println("Notification: A new account has been created.");
    }
}
