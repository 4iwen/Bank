package org.delta.atm;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;

import java.util.HashMap;

@Singleton
public class ATMService {

    @Inject
    ATMInfoPrinterService atmInfoPrinterService;

    HashMap<String, BaseATM> atms = new HashMap<>();

    public void withdraw(BaseATM atm, BaseCard card, float amount) {
        if (atm.insertedCard == null) {
            atmInfoPrinterService.noCardInserted();
            return;
        }

        BaseAccount account = card.getAccount();
        if (account.getBalance() < amount) {
            atmInfoPrinterService.notEnoughMoney();
            return;
        }

        account.subFromBalance(amount);
        atmInfoPrinterService.withdrawalInfo(amount, account);
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
