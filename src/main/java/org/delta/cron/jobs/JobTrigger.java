package org.delta.cron.jobs;

import org.quartz.Scheduler;

public interface JobTrigger {
    void register(Scheduler scheduler);
}
