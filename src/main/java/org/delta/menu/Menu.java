package org.delta.menu;

import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {

    public void printMenu() {
        MenuChoices.help();
    }

    public MenuChoices read() {
        try {
            System.out.print("What do you want: ");
            Scanner scanner = new Scanner(new InputStreamReader(System.in));
            int menuInput = scanner.nextInt();
            return MenuChoices.convertFromMenuInput(menuInput);
        } catch (Exception exception) {
            System.out.println("Input is not valid");

            return MenuChoices.INVALID_CHOICE;
        }


    }
}
