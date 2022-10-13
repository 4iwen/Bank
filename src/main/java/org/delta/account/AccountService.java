package org.delta.account;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class AccountService {
    private final Map<String, BaseAccount> accounts  = new HashMap<>();

    public void addAccount(BaseAccount account) {
        this.accounts.put(account.getId(), account);
    }

    public String generateAccountNumber() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(r.nextInt(100, 999));

            if (i < 2) {
                sb.append("-");
            }
        }

        return sb.toString();
    }

    public BaseAccount getAccountByAccountNumber(String accountNumber) {
        return this.accounts.get(accountNumber);
    }

    public BaseAccount[] getAccounts() {
        return this.accounts.values().toArray(new BaseAccount[0]);
    }
}
