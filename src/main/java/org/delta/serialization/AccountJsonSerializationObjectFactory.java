package org.delta.serialization;

import org.delta.account.AccountType;
import org.delta.account.BaseAccount;
import org.delta.card.BaseCard;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class AccountJsonSerializationObjectFactory {

    @Inject
    private PersonJsonSerializationObjectFactory personJsonSerializationObjectFactory;

    @Inject
    private CardJsonSerializationObjectFactory cardJsonSerializationObjectFactory;

    public AccountJsonSerializationObject create(BaseAccount account) {
        AccountJsonSerializationObject accountJsonSerializationObject = new AccountJsonSerializationObject();
        accountJsonSerializationObject.accountType = AccountType.getType(account);
        accountJsonSerializationObject.accountNumber = account.getAccountNumber();
        accountJsonSerializationObject.owner = personJsonSerializationObjectFactory.create(account.getOwner());
        accountJsonSerializationObject.balance = account.getBalance();
        for (BaseCard card : account.getCards()) {
            accountJsonSerializationObject.cards.add(cardJsonSerializationObjectFactory.create(card));
        }
        return accountJsonSerializationObject;
    }
}
