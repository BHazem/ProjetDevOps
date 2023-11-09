package tn.esprit.devops_project.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@DataJpaTest
 class SupplierServiceImplTest {

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    // Test for retrieveAllSuppliers method
    @Test
    void retrieveAllSuppliers_ShouldReturnSupplierList() {
        when(supplierRepository.findAll()).thenReturn(Collections.singletonList(new Supplier()));
        List<Supplier> result = supplierService.retrieveAllSuppliers();
        assertFalse(result.isEmpty());
        verify(supplierRepository).findAll();
    }

    // Test for addSupplier method
    @Test
    void addSupplier_ShouldReturnNewSupplier() {
        SupplierDto supplierDto = new SupplierDto();
        Supplier supplier = new Supplier();
        when(supplierRepository.save(any(Supplier.class))).thenReturn(supplier);
        Supplier result = supplierService.addSupplier(supplierDto);
        assertNotNull(result);
        verify(supplierRepository).save(any(Supplier.class));
    }

    // Test for updateSupplier method
    @Test
    void updateSupplier_ShouldReturnUpdatedSupplier() {
        SupplierDto supplierDto = new SupplierDto();
        Supplier supplier = new Supplier();
        when(supplierRepository.save(any(Supplier.class))).thenReturn(supplier);
        Supplier result = supplierService.updateSupplier(supplierDto);
        assertNotNull(result);
        verify(supplierRepository).save(any(Supplier.class));
    }

    // Test for deleteSupplier method
    @Test
    void deleteSupplier_ShouldInvokeRepositoryDelete() {
        Long supplierId = 1L;
        doNothing().when(supplierRepository).deleteById(anyLong());
        supplierService.deleteSupplier(supplierId);
        verify(supplierRepository).deleteById(supplierId);
    }

    // Test for retrieveSupplier method
    @Test
    void retrieveSupplier_ShouldReturnSupplier() {
        Long supplierId = 1L;
        Supplier supplier = new Supplier();
        when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));
        Supplier result = supplierService.retrieveSupplier(supplierId);
        assertNotNull(result);
        verify(supplierRepository).findById(supplierId);
    }

    // Additional test cases to handle exceptions, etc...
}
