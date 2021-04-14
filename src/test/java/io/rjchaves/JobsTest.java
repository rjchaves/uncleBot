package io.rjchaves;

import io.rjchaves.job.Job;
import io.rjchaves.job.Jobs;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class JobsTest
{
    private Jobs jobs;

    @Before
    public void init() {
        Job cuidarDosPorcos = new Job("Cuidar dos porcos", 5);
        Job afastarPassaros = new Job("Afastar os pássaros", 6);
        Job cacarPerus = new Job("Cacar Perus", 1);
        Job cacarCoiotes = new Job("Caçar coiotes", 20);
        Job cacarElefante = new Job("Caçar Elefante", 2);
        this.jobs = new Jobs();
        jobs.add(cuidarDosPorcos);
        jobs.add(afastarPassaros);
        jobs.add(cacarPerus);
        jobs.add(cacarCoiotes);
        jobs.add(cacarElefante);
    }

    @Test
    public void jobsOrderByExp() {
        var cacarCoiotes = new Job("Caçar coiotes", 20);
        assertEquals(this.jobs.getMostExpJob().get(), cacarCoiotes);
    }
}
