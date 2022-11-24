package org.delta.atm;

import javax.inject.Singleton;
import java.util.Random;

@Singleton
public class ATMFactory {
    public BaseATM createATM(String name, String location) {
        Random random = new Random();
        StringBuilder id = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            id.append(random.nextInt(1,9));
        }

        return new BaseATM(id.toString(), name, location);
    }
}
