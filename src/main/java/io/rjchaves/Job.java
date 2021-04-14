package io.rjchaves;

import java.util.Objects;

public class Job {
    private final String name;
    private final Integer experience;

    public Job(String name, Integer experience) {
        this.name = name;
        this.experience = experience;
    }

    public Integer getExperience() {
        return experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return name.equals(job.name) && experience.equals(job.experience);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience);
    }

    @Override
    public String toString() {
        return "Job{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                '}';
    }
}
