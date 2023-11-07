package tn.esprit.devops_project.services.iservices;

import tn.esprit.devops_project.dto.ActivitySectorDto;
import tn.esprit.devops_project.entities.ActivitySector;

import java.util.List;

public interface IActivitySector {
    List<ActivitySector> retrieveAllActivitySectors();

    ActivitySector addActivitySector(ActivitySectorDto activitySector);

    void deleteActivitySector(Long id);

    ActivitySector updateActivitySector(ActivitySectorDto activitySector);

    ActivitySector retrieveActivitySector(Long id);
}
