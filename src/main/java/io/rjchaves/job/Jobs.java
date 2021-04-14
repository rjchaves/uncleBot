package io.rjchaves.job;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Jobs {
    private final List<Job> jobList;

    public Jobs() {
        this.jobList = new ArrayList<>();
    }

    public void add(Job job) {
        this.jobList.add(job);
    }

    public Optional<Job> getMostExpJob() {
        return this.jobList.stream().min((job1, job2) ->
                job2.getExperience().compareTo(job1.getExperience()));
    }

}
