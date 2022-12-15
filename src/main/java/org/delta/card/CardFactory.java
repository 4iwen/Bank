package org.delta.card;

import org.delta.account.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardFactory {

    @Inject
    private CardService cardService;

    public BaseCard createCard(BaseAccount baseAccount, String cardNumber, String expiration, String cvc, CardType cardType) {
        BaseCard card = switch (cardType) {
            default -> new BaseCard(baseAccount, cardNumber, expiration, cvc);
            case CREDIT -> new CreditCard(baseAccount, cardNumber, expiration, cvc);
        };

        cardService.addCard(card);

        return card;
    }
}
