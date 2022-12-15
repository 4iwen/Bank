package org.delta.atm;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;
import org.delta.card.CardInfoPrinterService;
import org.delta.card.CreditCard;
import org.delta.card.CreditCardService;

import java.util.HashMap;

@Singleton
public class ATMService {

    @Inject
    ATMInfoPrinterService atmInfoPrinterService;

    @Inject
    CreditCardService creditCardService;

    @Inject
    CardInfoPrinterService cardInfoPrinterService;

    HashMap<String, BaseATM> atms = new HashMap<>();

    public void withdraw(BaseATM atm, BaseCard card, float amount) {
        if (atm.insertedCard == null) {
            atmInfoPrinterService.noCardInserted();
            return;
        }


        if (card instanceof CreditCard) {
            creditCardService.withdraw((CreditCard) card, amount);
            cardInfoPrinterService.withdrawInfo(amount);
        } else {
            BaseAccount account = card.getAccount();
            if (account.getBalance() < amount) {
                atmInfoPrinterService.notEnoughMoney();
                return;
            }
            account.subFromBalance(amount);
            atmInfoPrinterService.withdrawalInfo(amount, account);
        }
    }

    public void balance(BaseATM atm, BaseCard card) {
        if (atm.insertedCard == null) {
            atmInfoPrinterService.noCardInserted();
            return;
        }

        BaseAccount account = card.getAccount();
        account.printBalance();
    }

    public BaseATM addATM(BaseATM atm) {
        atms.put(atm.getId(), atm);
        return atm;
    }

    public void insertCard(BaseATM atm, BaseCard card) {
        atms.get(atm.getId()).insertedCard = card;
        atmInfoPrinterService.insertCardInfo(card);
    }

    public void ejectCard(BaseATM atm) {
        atms.get(atm.getId()).insertedCard = null;
        atmInfoPrinterService.ejectCardInfo();
    }
}
