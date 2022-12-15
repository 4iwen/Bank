package org.delta.account;

import com.google.common.eventbus.EventBus;
import org.delta.notification.persons.NotifyCustomerEvent;
import org.delta.observer.AccountCreationObserver;
import org.delta.observer.EmailSubject;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class AccountService {
    private final Map<String, BaseAccount> accounts  = new HashMap<>();

    EmailSubject emailSubject = new EmailSubject();

    @Inject
    private EventBus eventBus;

    public void addAccount(BaseAccount account) {
        this.accounts.put(account.getId(), account);

        // Notify observers
        AccountCreationObserver accountCreationObserver = new AccountCreationObserver();
        emailSubject.addObserver(accountCreationObserver);
        emailSubject.notifyObservers();
        emailSubject.removeObserver(accountCreationObserver);

        // Notify event bus
        eventBus.post(new NotifyCustomerEvent("Customer Name"));
    }

    public BaseAccount getAccountByAccountNumber(String accountNumber) {
        return this.accounts.get(accountNumber);
    }

    public BaseAccount[] getAccounts() {
        return this.accounts.values().toArray(new BaseAccount[0]);
    }

}
