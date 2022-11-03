package org.delta.menu;

public enum MenuChoices {
    HELP, DETAIL, CREATE_PERSON, CREATE_ACCOUNT, LOAD, SAVE, EXIT, INVALID_CHOICE;

    public static MenuChoices convertFromMenuInput(int menuInput) {
        return switch (menuInput) {
            case 1 -> HELP;
            case 2 -> DETAIL;
            case 3 -> CREATE_PERSON;
            case 4 -> CREATE_ACCOUNT;
            case 5 -> SAVE;
            case 6 -> LOAD;
            case 0 -> EXIT;
            default -> INVALID_CHOICE;
        };
    }

    public static void help() {
        System.out.println("MENU:");

        System.out.println(":: HELP: 1");
        System.out.println(":: DETAIL: 2");
        System.out.println(":: CREATE_PERSON: 3");
        System.out.println(":: CREATE_ACCOUNT: 4");
        System.out.println(":: SAVE: 5");
        System.out.println(":: LOAD: 6");
        System.out.println(":: EXIT: 0");
    }

    public static void exit() {
        System.out.println("Exiting...");
    }
}
