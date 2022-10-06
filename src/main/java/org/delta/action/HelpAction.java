package org.delta.action;

import org.delta.menu.MenuChoices;

public class HelpAction implements Action {

    @Override
    public void processAction() {
        MenuChoices.help();
    }
}
