package org.delta.card;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CreditCardService {


    public void withdraw(CreditCard card, float amount) {
        if ((card.creditLimit + card.credit) - amount < 0) {
            return;
        }

        card.credit -= amount;
    }

    public void interest(CreditCard card) {
        if (card.credit < 0) {
            card.credit += card.credit * 0.1f;
        }
    }

    public void deposit(CreditCard card, float amount) {
        card.credit += amount;
    }
}
