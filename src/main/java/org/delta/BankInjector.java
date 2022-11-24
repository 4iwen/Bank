package org.delta;

import com.google.common.eventbus.EventBus;
import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;
import com.google.inject.matcher.Matchers;
import com.google.inject.multibindings.MapBinder;
import com.google.inject.spi.InjectionListener;
import com.google.inject.spi.TypeEncounter;
import com.google.inject.spi.TypeListener;
import org.delta.action.*;
import org.delta.menu.MenuChoices;
import org.delta.storage.FileSystemStorage;
import org.delta.storage.Storage;

import java.awt.event.ActionListener;

public class BankInjector extends AbstractModule {

    private EventBus eventBus = new EventBus("Default event bus");

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

        this.bind(EventBus.class).toInstance(eventBus);

        bindListener(Matchers.any(), new TypeListener() {
            @Override
            public <I> void hear(TypeLiteral<I> typeLiteral, TypeEncounter<I> typeEncounter) {
                typeEncounter.register(new InjectionListener<I>() {
                    @Override
                    public void afterInjection(I i) {
                        eventBus.register(i);
                    }
                });
            }
        });
    }
}
