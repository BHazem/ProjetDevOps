package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.entities.SupplierCategory;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SupplierServiceImplTest {

    List<Supplier> supplierList = new ArrayList<Supplier>() {
        {
            add(new Supplier(1L, "Supplier 1", "Code 1", SupplierCategory.CONVENTIONNE));
            add(new Supplier(2L, "Supplier 2", "Code 2", SupplierCategory.ORDINAIRE));
        }
    };

    @InjectMocks
    private SupplierServiceImpl supplierService;
    @Mock
    private SupplierRepository supplierRepository;

    @Test
    void retrieveAllSuppliers() {
        Mockito.when(supplierService.retrieveAllSuppliers()).thenReturn(supplierList);
        List<Supplier> list = supplierService.retrieveAllSuppliers();
        Assertions.assertNotNull(list);
    }


    }