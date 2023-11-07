package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.dto.ActivitySectorDto;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;
import tn.esprit.devops_project.services.iservices.IActivitySector;

import java.util.List;

@Service
@AllArgsConstructor
public class ActivitySectorImpl implements IActivitySector {

    ActivitySectorRepository activitySectorRepository;
    @Override
    public List<ActivitySector> retrieveAllActivitySectors() {
        return activitySectorRepository.findAll();
    }

    @Override
    public ActivitySector addActivitySector(ActivitySectorDto activitySectorDto) {
        ActivitySector activitySector = convertDtoToEntity(activitySectorDto);

        return activitySectorRepository.save(activitySector);
    }

    private ActivitySector convertDtoToEntity(ActivitySectorDto dto) {
        // create an instance of ActivitySector and set its fields using the values from the dto
        ActivitySector entity = new ActivitySector();
        entity.setCodeSecteurActivite(dto.getCodeSecteurActivite());
        entity.setLibelleSecteurActivite(dto.getLibelleSecteurActivite());
        // ... set other fields ...
        return entity;
    }
    @Override
    public void deleteActivitySector(Long id) {
        activitySectorRepository.deleteById(id);
    }

    @Override
    public ActivitySector updateActivitySector(ActivitySectorDto activitySectorDto) {
        ActivitySector activitySector = convertDtoToEntity(activitySectorDto);

        return activitySectorRepository.save(activitySector);
    }

    @Override
    public ActivitySector retrieveActivitySector(Long id) {
        return activitySectorRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid activitySector Id:" + id));
    }
}
