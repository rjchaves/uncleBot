package io.rjchaves;

public class JobsController {

    private final Interactable interactable;

    public JobsController(Interactable interactable) {
        this.interactable = interactable;
    }

    public void enqueueJobWithMostExp() {
        var job = interactable.getJobs().getMostExpJob();
        job.ifPresent(interactable::enqueueJob);
    }
}
