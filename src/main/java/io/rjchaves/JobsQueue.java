package io.rjchaves;

import io.rjchaves.job.JobsController;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class JobsQueue implements Job {

    private final JobsController jobsController;
    public JobsQueue(JobsController jobsController) {
        this.jobsController = jobsController;
    }

    public void start() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail jobDetail = newJob(JobsQueue.class)
                .withIdentity("job1", "group1")
                .build();

        Trigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule()
                        .withIntervalInSeconds(15*4+10)
                        .repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        for(int i = 0; i < 4; i++) {
            jobsController.enqueueJobWithMostExp();
        }
    }
}
