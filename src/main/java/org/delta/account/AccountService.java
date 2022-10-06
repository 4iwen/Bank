package org.delta.account;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Singleton
public class AccountService {
    private final List<BaseAccount> accounts  = new LinkedList<>();

    public void addAccount(BaseAccount account) {
        this.accounts.add(account);
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
}
