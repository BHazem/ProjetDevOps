package tn.esprit.devops_project.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

@SpringBootTest
class ActivitySectorImplTest {

    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @InjectMocks // Creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations.
    private ActivitySectorImpl activitySectorService;

    private AutoCloseable closeable;

    // This method is called before each test execution.


    // Each method annotated with @Test is a test case.
    @Test
    void testAddActivitySector() {
        // Arrange: Create a mock object and define its behavior.
        ActivitySector activitySector = new ActivitySector(1L, "CODE1", "IT", null);
        when(activitySectorRepository.save(any(ActivitySector.class))).thenReturn(activitySector);

        // Act: Call the method under test.
        ActivitySector result = activitySectorService.addActivitySector(activitySector);

        // Assert: Verify the output is as expected.
        Assertions.assertNotNull(result);
        Assertions.assertEquals(activitySector.getIdSecteurActivite(), result.getIdSecteurActivite());
    }

    @Test
    void testDeleteActivitySector() {
        // Arrange
        doNothing().when(activitySectorRepository).deleteById(anyLong());

        // Act
        activitySectorService.deleteActivitySector(1L);

        // Assert: Verify the method was called.
        verify(activitySectorRepository, times(1)).deleteById(1L);
    }

    @Test
    void testUpdateActivitySector() {
        // Arrange
        ActivitySector originalActivitySector = new ActivitySector(1L, "CODE1", "IT", null);
        ActivitySector updatedActivitySector = new ActivitySector(1L, "CODE2", "Finance", null);

        ArgumentCaptor<ActivitySector> activitySectorCaptor = ArgumentCaptor.forClass(ActivitySector.class);
        when(activitySectorRepository.save(activitySectorCaptor.capture())).thenReturn(updatedActivitySector);

        // Act
        ActivitySector result = activitySectorService.updateActivitySector(updatedActivitySector);

        // Assert
        ActivitySector capturedActivitySector = activitySectorCaptor.getValue();
        Assertions.assertNotNull(result);
        Assertions.assertEquals("CODE2", capturedActivitySector.getCodeSecteurActivite(),
                "The sector code should be updated to CODE2 but was " + capturedActivitySector.getCodeSecteurActivite());
    }


    @Test
    void testRetrieveActivitySector() {
        // Arrange
        Long id = 1L;
        Optional<ActivitySector> activitySector = Optional.of(new ActivitySector(id, "CODE1", "IT", null));
        when(activitySectorRepository.findById(id)).thenReturn(activitySector);

        // Act
        ActivitySector result = activitySectorService.retrieveActivitySector(id);

        // Assert
        Assertions.assertNotNull(result);
        Assertions.assertEquals(id, result.getIdSecteurActivite());
    }

    @Test
    void retrieveAllActivitySectors() {
        // Arrange
        List<ActivitySector> activitySectors = Arrays.asList(
                new ActivitySector(1L, "CODE1", "IT", null),
                new ActivitySector(2L, "CODE2", "Finance", null)
        );
        when(activitySectorRepository.findAll()).thenReturn(activitySectors);

        // Act
        List<ActivitySector> result = activitySectorService.retrieveAllActivitySectors();

        // Assert
        Assertions.assertFalse(result.isEmpty());
        Assertions.assertEquals(2, result.size());
    }
}
