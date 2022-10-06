package org.delta.account;

public enum AccountType {
    BASE, STUDENT, SAVINGS;

    public static String getType(BaseAccount account) {
        if (account instanceof StudentAccount) {
            return STUDENT.toString();
        } else if (account instanceof SavingAccount) {
            return SAVINGS.toString();
        } else {
            return BASE.toString();
        }
    }
}
