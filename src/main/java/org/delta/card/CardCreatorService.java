package org.delta.card;

import org.delta.account.BaseAccount;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class CardCreatorService {

    @Inject
    private CardFactory cardFactory;

    @Inject
    private CardDataGeneratorService cardDataGeneratorService;

    public void createCardAndSetIntoAccount(BaseAccount baseAccount) {

        String cardNumber = cardDataGeneratorService.generateCardNumber();
        String expiration = cardDataGeneratorService.generateExpirationDate();
        String cvc = cardDataGeneratorService.generateCvc();

        BaseCard card = this.cardFactory.createBaseCard(baseAccount, cardNumber, expiration, cvc);
        baseAccount.addCard(card);
    }

}
