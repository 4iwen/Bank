package org.delta.card;

import javax.inject.Singleton;

@Singleton
public class CardInfoPrinterService {
    public void printCardInfo(BaseCard card) {
        System.out.println("Card number: " + card.getCardNumber() + ", expiration: " + card.getExpiration() + ", cvc: " + card.getCvc());
    }

    public void cannotWithdraw(float amount) {
        System.out.println("Cannot withdraw " + amount + " from credit card");
    }

    public void depositInfo(float amount) {
        System.out.println("Deposited " + amount + " to credit card");
    }

    public void interestInfo() {
        System.out.println("Credit card gained debt");
    }

    public void withdrawInfo(float amount) {
        System.out.println("Withdrew " + amount + " from credit card");
    }
}
