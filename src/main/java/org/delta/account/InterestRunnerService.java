package org.delta.account;

import javax.inject.Singleton;

@Singleton
public class InterestRunnerService {

    private InterestCalculator interestCalculator;

    public InterestRunnerService() {
        this.interestCalculator = new InterestCalculator();
    }

    public void run(BaseAccount[] accounts) {
        for (BaseAccount account : accounts) {

            if (!(account instanceof AccountWithInterest)) {
                continue;
            }

            float interest = this.interestCalculator.calculateInterest(account);
            account.addToBalance(interest);
        }
    }
}
