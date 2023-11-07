package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.devops_project.dto.ActivitySectorDto;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
class ActivitySectorImplTest {

    @Mock
    private ActivitySectorRepository activitySectorRepository;

    @InjectMocks // Creates an instance of the class and injects the mocks that are created with the @Mock (or @Spy) annotations.
    private ActivitySectorImpl activitySectorService;



    @Test
    void testAddActivitySector() {
        // Arrange
        ActivitySectorDto dto = new ActivitySectorDto(1L, "CODE1", "IT");
        ActivitySector activitySector = new ActivitySector(1L, "CODE1", "IT", null);
        when(activitySectorRepository.save(any(ActivitySector.class))).thenReturn(activitySector);

        // Act
        ActivitySector result = activitySectorService.addActivitySector(dto);

        // Assert
        assertNotNull(result);
        assertEquals(activitySector.getIdSecteurActivite(), result.getIdSecteurActivite());
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
    private ActivitySector convertDtoToEntity(ActivitySectorDto dto) {
        // create an instance of ActivitySector and set its fields using the values from the dto
        ActivitySector entity = new ActivitySector();
        entity.setCodeSecteurActivite(dto.getCodeSecteurActivite());
        entity.setLibelleSecteurActivite(dto.getLibelleSecteurActivite());
        // ... set other fields ...
        return entity;
    }
    @Test
    void testUpdateActivitySector() {
        // Arrange
        ActivitySectorDto dto = new ActivitySectorDto(1L, "CODE2", "IT");
        ActivitySector activitySector = convertDtoToEntity(dto);


        ArgumentCaptor<ActivitySector> activitySectorCaptor = ArgumentCaptor.forClass(ActivitySector.class);
        when(activitySectorRepository.save(activitySectorCaptor.capture())).thenReturn(activitySector);

        // Act
        ActivitySector result = activitySectorService.updateActivitySector(dto);

        // Assert
        ActivitySector capturedActivitySector = activitySectorCaptor.getValue();
        assertNotNull(result);
        assertEquals("CODE2", capturedActivitySector.getCodeSecteurActivite(),
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
        assertNotNull(result);
        assertEquals(id, result.getIdSecteurActivite());
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
        assertEquals(2, result.size());
    }
}
