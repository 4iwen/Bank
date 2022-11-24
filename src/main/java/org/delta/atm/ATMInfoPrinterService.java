package org.delta.atm;

import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;

import javax.inject.Singleton;

@Singleton
public class ATMInfoPrinterService {
    public void printATMInfo(BaseATM atm) {
        System.out.println("ATM ID: " + atm.getId());
        System.out.println("ATM name: " + atm.getName());
        System.out.println("ATM location: " + atm.getLocation());
        System.out.println("ATM inserted card: " + atm.insertedCard.getCardNumber());
    }

    public void noCardInserted() {
        System.out.println("No card inserted");
    }

    public void withdrawalInfo(float amount, BaseAccount account) {
        System.out.println("Withdrawn " + amount + " from account " + account.getAccountNumber());
    }

    public void insertCardInfo(BaseCard card) {
        System.out.println("Inserted card " + card.getCardNumber());
    }

    public void ejectCardInfo() {
        System.out.println("Card ejected");
    }

    public void notEnoughMoney() {
        System.out.println("Not enough money");
    }
}
