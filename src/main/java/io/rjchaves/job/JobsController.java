package io.rjchaves.job;

import io.rjchaves.Character;

public class JobsController {

    private final Interactable interactable;
    private final Character character;
    private static final Integer EXPERIENCE_THRESHOLD = 4;

    public JobsController(Interactable interactable, Character character) {
        this.interactable = interactable;
        this.character = character;
    }

    public void enqueueJobWithMostExp() {
        if (!haveEnoughtEnergy()) return;
        var job = interactable.getJobs().getMostExpJob();
        job.ifPresent(interactable::enqueueJob);
    }

    private boolean haveEnoughtEnergy() {
        return character.getEnergy() <= EXPERIENCE_THRESHOLD;
    }
}
