package org.delta.account;

import org.delta.card.BaseCard;
import org.delta.person.Person;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Acount types:
 * <ul>
 *  <li>>Current account - an account used primarily to facilitate cash and non-cash administration, manipulation and management of funds (transfers, payments, deposits).</li
 *  <li>Savings account - an account that is most often used to save or store temporarily free funds at a higher interest rate.</li
 *  <li>Time deposit - an account used to deposit free funds at a higher interest rate.</li
 *  <li>Loan account - an account in which the bank records the balance of a loan granted.</li
 *  <li>Basic payment account - an account under the European Directive on the right to a bank account.</li
 *  <li>Non-interest bearing account - for example, a notarial custody account.</li
 *  <li>Loro and Nostro account - a current account held by a bank with a bank abroad.</li
 * </ul>
 * <p>
 * Account services
 * <ul>
 *  <li>Overdraft - a service that allows the customer to draw money from the account up to a certain negative balance (overdraft).</li>
 *  <li>Payment card, debit or credit - a customer's non-cash payment instrument, usually issued by a bank.</li>
 *  <li>Direct and Internet banking - a method of banking between the bank and the customer that allows access to the account without visiting a bank branch by mail, telephone, ATM, mobile devices or via the Internet.</li>
 *  <li>Bank and Traveller's Cheques - short-term securities issued by a bank as an accepted money order. A cheque is cashed upon presentation of the cheque by the bank.</li>
 * </ul>
 */

public class BaseAccount {


    private String accountNumber;
    private Person owner;

    private float balance;

    private final List<BaseCard> cards = new LinkedList<>();

    public BaseAccount(String accountNumber, Person owner, float balance) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
    }

    public void addToBalance(float amount) {
        this.balance += amount;
    }

    public void subFromBalance(float amount) {
        this.balance -= amount;
    }

    public Person getOwner() {
        return owner;
    }

    public float getBalance() {
        return balance;
    }

    public void addCard(BaseCard card) {
        this.cards.add(card);
    }

    public int getCardCount() {
        return this.cards.size();
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public List<BaseCard> getCards() {
        return this.cards;
    }

    public void printBalance() {
        System.out.println("Account balance: " + this.balance);
    }

    public String getId() {
        return this.accountNumber;
    }

    public void setCards(List<BaseCard> cards) {
        this.cards.clear();
        this.cards.addAll(cards);
    }
}
