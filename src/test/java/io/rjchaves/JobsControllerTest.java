package io.rjchaves;

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

    @InjectMocks
    private JobsController jobController;
    private Job cuidarDosPorcos;
    private Job afastarPassaros;
    private Job cacarPerus;

    @Before
    public void init() {
        cuidarDosPorcos = new Job("Cuidar dos porcos", 5);
        afastarPassaros = new Job("Afastar os pássaros", 6);
        cacarPerus = new Job("Cacar Perus", 1);
        var jobs = new Jobs();
        jobs.add(cuidarDosPorcos);
        jobs.add(afastarPassaros);
        jobs.add(cacarPerus);
        this.jobController = new JobsController(interactable);
        when(interactable.getJobs()).thenReturn(jobs);
    }

    @Test
    public void enqueueJobWithMostExp() {
        this.jobController.enqueueJobWithMostExp();
        verify(interactable, times(1)).enqueueJob(afastarPassaros);
    }
}
