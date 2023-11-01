package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.services.Iservices.IActivitySector;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ActivitySectorImplTest {
    @Autowired
    IActivitySector iActivitySector;

@Test
    public void retrieveAllActivitySectors()
    {
        List<ActivitySector> activitySectors = iActivitySector.retrieveAllActivitySectors();
        Assertions.assertEquals(0,activitySectors.size());
    }

}