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
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SupplierServiceImplTest {

    List<Supplier> supplierList = new ArrayList<Supplier>() {
        {
            add( Supplier.builder().label("Label").code("Code").supplierCategory(SupplierCategory.ORDINAIRE).build());
            add( Supplier.builder().label("Label").code("Code").supplierCategory(SupplierCategory.ORDINAIRE).build());
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

    /* @Test
    void addSupplier() {
        Supplier newSupplier = new Supplier().builder()
                .code("New Supplier")
                .label("New Code")
                .supplierCategory(SupplierCategory.ORDINAIRE)
                .build();

        Mockito.when(supplierRepository.save(Mockito.any(Supplier.class))).thenReturn(newSupplier);

        Supplier s = supplierService.addSupplier(newSupplier);

        assertThat(s).isNotNull();

        supplierService.deleteSupplier(newSupplier.getIdSupplier());

    }
*/
    @Test
    void deleteSupplier() {
        // Créez un fournisseur existant pour le supprimer
        Supplier existingSupplier = Supplier.builder().label("Label").code("Code").supplierCategory(SupplierCategory.ORDINAIRE).build();


        // Mockito pour simuler le comportement du repository lors de la suppression
        Mockito.doNothing().when(supplierRepository).deleteById(1L);

        // Appel de la méthode de suppression
        supplierService.deleteSupplier(1L);

        // Vérification que le fournisseur a été supprimé
        Supplier deletedSupplier = supplierRepository.findById(1L).orElse(null);
        assertThat(deletedSupplier).isNull();
    }

    /*@Test
    void retrieveSupplier() {
        // Créez un fournisseur existant
        Supplier existingSupplier = Supplier.builder().label("Label").code("Code").supplierCategory(SupplierCategory.ORDINAIRE).build();

        supplierService.addSupplier(existingSupplier);
        // Mockito pour simuler le comportement du repository lors de la recherche par ID
        Mockito.when(supplierRepository.findById(existingSupplier.getIdSupplier())).thenReturn(Optional.of(existingSupplier));

        // Appel de la méthode de recherche par ID
        Supplier retrievedSupplier = supplierService.retrieveSupplier(existingSupplier.getIdSupplier());

        // Vérification des résultats
        assertThat(retrievedSupplier).isNotNull();
        assertThat(retrievedSupplier.getCode()).isEqualTo("Code");
        assertThat(retrievedSupplier.getLabel()).isEqualTo("Label");
        assertThat(retrievedSupplier.getSupplierCategory()).isEqualTo(SupplierCategory.ORDINAIRE);
    }
    */

}