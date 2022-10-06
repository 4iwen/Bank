package org.delta.card;

import javax.inject.Singleton;
import java.util.Random;
import java.time.Month;
import java.time.LocalDate;

@Singleton
public class CardDataGeneratorService {


    Random r = new Random();

    public String generateCardNumber() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            sb.append(r.nextInt(1000, 9999));

            if (i < 3) {
                sb.append("-");
            }
        }

        return sb.toString();
    }

    public String generateExpirationDate() {
        LocalDate localDate = LocalDate.now();
        Month month = localDate.getMonth();

        StringBuilder sb = new StringBuilder();
        if (month.getValue() < 10) {
            sb.append("0");
        }
        sb.append(month.getValue());
        sb.append("/");
        sb.append(localDate.getYear() + 5);

        return sb.toString();
    }

    public String generateCvc() {
        return String.valueOf(r.nextInt(100, 999));
    }
}
