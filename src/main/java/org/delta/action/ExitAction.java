package org.delta.action;

import org.delta.menu.MenuChoices;

public class ExitAction implements Action {

    @Override
    public void processAction() {
        MenuChoices.exit();
    }
}
