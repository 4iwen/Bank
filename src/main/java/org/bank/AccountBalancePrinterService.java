package org.bank;
public class AccountBalancePrinterService {
    public void printInfo(BaseAccount account) {
        System.out.println(account.getOwner().getFullName() + "'s balance: " + account.getBalance());
    }
}
