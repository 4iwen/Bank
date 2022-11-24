package org.delta;

import org.apache.log4j.BasicConfigurator;
import org.delta.cron.jobs.ExampleJobTrigger;
import org.delta.cron.jobs.GuiceJobFactory;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class QuartzScheduler {
    @Inject
    private GuiceJobFactory jobFactory;

    @Inject
    private ExampleJobTrigger exampleJobTrigger;

    public void registerJobs() {
        try {
            BasicConfigurator.configure();

            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            exampleJobTrigger.register(scheduler);

            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}
