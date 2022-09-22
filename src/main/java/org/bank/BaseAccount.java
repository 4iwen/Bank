package org.bank;
public class BaseAccount {
    private final Person owner;
    private float balance;

    public BaseAccount(Person owner, float balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void printBalance() {
        System.out.println(owner.getFullName() + "'s balance: " + balance);
    }

    public void sendMoney(BaseAccount targetAccount, float amount) {
        this.subtractFromBalance(amount);
        targetAccount.addToBalance(amount);
    }

    public void addToBalance(float amount) {
        balance += amount;
    }

    public void subtractFromBalance(float amount) {
        balance -= amount;
    }

    public Person getOwner() {
        return owner;
    }

    public float getBalance() {
        return balance;
    }
}
