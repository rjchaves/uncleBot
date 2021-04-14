package io.rjchaves.job;

public interface Interactable {
    Jobs getJobs();

    void enqueueJob(Job job);
}
