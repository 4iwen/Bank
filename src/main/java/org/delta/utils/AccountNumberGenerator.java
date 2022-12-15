package org.delta.utils;

import java.util.Random;

public class AccountNumberGenerator {
    public String generateAccountNumber() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            sb.append(r.nextInt(100, 999));

            if (i < 2) {
                sb.append("-");
            }
        }

        return sb.toString();
    }
}
