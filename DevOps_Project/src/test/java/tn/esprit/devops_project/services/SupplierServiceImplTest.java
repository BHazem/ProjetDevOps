package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.List;

@SpringBootTest
class SupplierServiceImplTest {
    @Autowired
    ISupplierService iSupplierService;

    @Test
    public void retrieveAllActivitySectors()
    {

        List<Supplier> activitySectors = iSupplierService.retrieveAllSuppliers();
        Assertions.assertEquals(0,activitySectors.size());
    }


}