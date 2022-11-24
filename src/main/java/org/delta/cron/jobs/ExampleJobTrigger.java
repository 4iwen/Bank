package org.delta.cron.jobs;

import org.quartz.*;

import javax.inject.Singleton;

@Singleton
public class ExampleJobTrigger implements JobTrigger {

    @Override
    public void register(Scheduler scheduler) {
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(9)
                        .repeatForever())
                .build();

        JobDetail jobInstance = JobBuilder.newJob(SimpleCronJob.class)
                .withIdentity("job1", "group1")
                .build();

        try {
            scheduler.scheduleJob(jobInstance, trigger);
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }

    }
}
