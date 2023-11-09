package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.repositories.InvoiceRepository;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
class InvoiceServiceImplTest {


    @InjectMocks
    private InvoiceServiceImpl invoiceService;
   @Mock
    private InvoiceRepository invoiceRepository;

    List<Invoice> invoiceList = new ArrayList<Invoice>() {
        {
            add(new Invoice(1f, 50f,false));
            add(new Invoice(2f,40f, true));
        }
    };


    @Test
    void retrieveAllInvoices() {
        Mockito.when(invoiceService.retrieveAllInvoices()).thenReturn(invoiceList);
        List<Invoice> list = invoiceService.retrieveAllInvoices();
        Assertions.assertNotNull(list);
    }

    /* @Test
     void cancelInvoice_ShouldCancelTheInvoice() {
         // Arrange
         Long invoiceId = 1L;
         Invoice invoice = new Invoice();
         when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));
         doNothing().when(invoiceRepository).save(any(Invoice.class));

         // Act
         invoiceService.cancelInvoice(invoiceId);

         // Assert
         assertTrue(invoice.getArchived());
         verify(invoiceRepository).save(invoice);
     }
 */
    @Test
    void retrieveInvoice() {
        Invoice invoice = new Invoice(1f, 50f,false);

        Mockito.when(invoiceService.retrieveInvoice(Mockito.any())).thenReturn(invoice);

        Invoice invoice1 = invoiceService.retrieveInvoice(2L);
        assertThat(invoice1.getIdInvoice()).isEqualTo(2L);
        assertThat(invoice1).isNotNull();
    }

    /* @Test
       void getInvoicesBySupplier() {
           // Arrange
           Long supplierId = 1L;
           Supplier supplier = mock(Supplier.class);
           when(supplierRepository.findById(supplierId)).thenReturn(Optional.of(supplier));
           when(supplier.getInvoices()).thenReturn(null);

           // Act
           List<Invoice> result = invoiceService.getInvoicesBySupplier(supplierId);

           // Assert
           assertNotNull(result);
           verify(supplierRepository).findById(supplierId);
       }
 */
   /* @Test
    void assignOperatorToInvoice() {
        // Arrange
        Long operatorId = 1L;
        Long invoiceId = 1L;
        Operator operator = new Operator();
        Invoice invoice = new Invoice();
        when(operatorRepository.findById(operatorId).orElse(null));
        when(invoiceRepository.findById(invoiceId).orElse(null));

        // Act
        invoiceService.assignOperatorToInvoice(operatorId, invoiceId);

        // Assert
        assertTrue(operator.getInvoices().contains(invoice));
        verify(operatorRepository).save(operator);
    }
*/
    /*@Test
    void getTotalAmountInvoiceBetweenDates() {
        // Arrange
        Date startDate = new Date();
        Date endDate = new Date();
        when(invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(100.0f);

        // Act
        float totalAmount = invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        // Assert
        assertEquals(100.0f, totalAmount);
        verify(invoiceRepository).getTotalAmountInvoiceBetweenDates(startDate, endDate);
    }*/

    // Additional test cases...
}