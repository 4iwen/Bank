package org.delta.menu;

public enum MenuChoices {
    HELP, DETAIL, ACCOUNTS, CREDIT, SAVING, EXIT, INVALID_CHOICE;

    public static MenuChoices convertFromMenuInput(int menuInput) {
        return switch (menuInput) {
            case 1 -> HELP;
            case 2 -> DETAIL;
            case 3 -> ACCOUNTS;
            case 4 -> CREDIT;
            case 5 -> SAVING;
            case 6 -> EXIT;
            default -> INVALID_CHOICE;
        };
    }

    public static void help() {
        System.out.println("MENU:");

        System.out.println(":: HELP: 1");
        System.out.println(":: DETAIL: 2");
        System.out.println(":: ACCOUNTS: 3");
        System.out.println(":: CREDIT: 4");
        System.out.println(":: SAVING: 5");
        System.out.println(":: EXIT: 6");
    }
}
