package io.rjchaves;

public interface Interactable {
    Jobs getJobs();

    void enqueueJob(Job job);
}
