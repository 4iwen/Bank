package org.delta.card;

import javax.inject.Singleton;

@Singleton
public class CardInfoPrinterService {
    public void printCardInfo(BaseCard card) {
        System.out.println("Card number: " + card.getCardNumber() + ", expiration: " + card.getExpiration() + ", cvc: " + card.getCvc());
    }
}
