package org.delta;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.MapBinder;
import org.delta.action.*;
import org.delta.menu.MenuChoices;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.Storage;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(Storage.class).to(FileSystemStorage.class);

        MapBinder<MenuChoices, Action> uriBinder = MapBinder.newMapBinder(binder(), MenuChoices.class, Action.class);
        uriBinder.addBinding(MenuChoices.SAVE).to(SaveAction.class);
        uriBinder.addBinding(MenuChoices.LOAD).to(LoadAction.class);
        uriBinder.addBinding(MenuChoices.CREATE_ACCOUNT).to(CreateAccountAction.class);
        uriBinder.addBinding(MenuChoices.CREATE_PERSON).to(CreatePersonAction.class);
        uriBinder.addBinding(MenuChoices.HELP).to(HelpAction.class);
        uriBinder.addBinding(MenuChoices.DETAIL).to(DetailAction.class);
        uriBinder.addBinding(MenuChoices.EXIT).to(ExitAction.class);

    }
}
