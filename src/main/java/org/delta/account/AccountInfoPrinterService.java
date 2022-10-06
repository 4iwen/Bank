package org.delta.account;

import org.delta.card.BaseCard;
import org.delta.card.CardInfoPrinterService;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class AccountInfoPrinterService {

    @Inject
    private CardInfoPrinterService cardInfoPrinterService;

    public void printAccountInfo(BaseAccount account) {
        System.out.println(this.getTypePrefix(account) + "Balance of " + account.getOwner().getFullName() + " account (" + account.getAccountNumber() + ") is " + account.getBalance() + ", number of cards: " + account.getCardCount());

        if (account.getCardCount() > 0) {
            List<BaseCard> cards = account.getCards();

            for (BaseCard card : cards)
            {
                cardInfoPrinterService.printCardInfo(card);
            }
        }
    }

    private String getTypePrefix(BaseAccount account) {
        if (account instanceof StudentAccount) {
            return "[Student] ";
        }

        if (account instanceof SavingAccount) {
            return "[Saving] ";
        }

        return "[Base] ";
    }

}
