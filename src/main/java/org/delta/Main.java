package org.delta;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.log4j.BasicConfigurator;
import org.delta.account.BaseAccount;
import org.delta.cron.jobs.SimpleCronJob;
import org.delta.io.IO;
import org.delta.notification.persons.NotifyCustomerEventListener;
import org.delta.serialization.AccountJsonSerializationObjectFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new BankInjector());

        Bank bank = injector.getInstance(Bank.class);
        injector.getInstance(NotifyCustomerEventListener.class);
        //bank.startTerminal();
        bank.atmExample();
    }
}