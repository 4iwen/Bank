package org.delta.action;

import org.delta.menu.MenuChoices;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class ActionListener {

    final private Map<MenuChoices, Action> registeredActions;

    public ActionListener() {
        this.registeredActions = new HashMap<>();
    }

    public void registerAction(MenuChoices menuChoices, Action action) {
        this.registeredActions.put(menuChoices, action);
    }

    public void processAction(MenuChoices menuChoices) {
        Action action = this.registeredActions.get(menuChoices);
        if (action != null) {
            action.processAction();
        }
    }
}
