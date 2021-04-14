package io.rjchaves;

import io.rjchaves.job.Interactable;
import io.rjchaves.job.Job;
import io.rjchaves.job.Jobs;
import io.rjchaves.job.JobsController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JobsControllerTest {

    @Mock
    private Interactable interactable;

    @Mock
    private Character character;

    @InjectMocks
    private JobsController jobController;

    private Job afastarPassaros;

    @Before
    public void init() {
        Job cuidarDosPorcos = new Job("Cuidar dos porcos", 5);
        Job cacarPerus = new Job("Cacar Perus", 1);
        afastarPassaros = new Job("Afastar os pássaros", 6);
        var jobs = new Jobs();
        jobs.add(cuidarDosPorcos);
        jobs.add(afastarPassaros);
        jobs.add(cacarPerus);
        this.jobController = new JobsController(interactable, character);
        when(interactable.getJobs()).thenReturn(jobs);
    }

    @Test
    public void enqueueJobWithMostExp() {
        when(character.getEnergy()).thenReturn(5);

        this.jobController.enqueueJobWithMostExp();

        verify(interactable, times(1)).enqueueJob(afastarPassaros);
    }

    @Test
    public void dontTryToEnqueueWhenCharacterIsOutOfEnergy() {
        when(character.getEnergy()).thenReturn(4);
        this.jobController.enqueueJobWithMostExp();
        verifyNoInteractions(interactable);
    }
}
