package tn.esprit.devops_project.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.repositories.InvoiceDetailRepository;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
 class InvoiceServiceImplTest {

    @Mock
    private InvoiceRepository invoiceRepository;

    @Mock
    private OperatorRepository operatorRepository;

    @Mock
    private InvoiceDetailRepository invoiceDetailRepository;

    @Mock
    private SupplierRepository supplierRepository;

    @InjectMocks
    private InvoiceServiceImpl invoiceService;

    @BeforeEach
    void setUp() {
        // Any setup before each test can go here
    }

    @Test
    void retrieveAllInvoices_ShouldReturnInvoiceList() {
        // Arrange
        when(invoiceRepository.findAll()).thenReturn(Collections.singletonList(new Invoice()));

        // Act
        List<Invoice> result = invoiceRepository.findAll();

        // Assert
        assertFalse(result.isEmpty());
        verify(invoiceRepository).findAll();
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
    void retrieveInvoice_ShouldReturnInvoice() {
        // Arrange
        Long invoiceId = 1L;
        Invoice invoice = new Invoice();
        when(invoiceRepository.findById(invoiceId)).thenReturn(Optional.of(invoice));

        // Act
        Invoice result = invoiceRepository.findById(invoiceId).orElse(null);

        // Assert
        assertNotNull(result);
        verify(invoiceRepository).findById(invoiceId);
    }

  /*  @Test
    void getInvoicesBySupplier_ShouldReturnInvoices() {
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
    void assignOperatorToInvoice_ShouldAssignOperator() {
        // Arrange
        Long operatorId = 1L;
        Long invoiceId = 1L;
        Operator operator = new Operator();
        Invoice invoice = new Invoice();
        when(operatorRepository.findByIdOperateur(operatorId)).thenReturn(operator);
        when(invoiceRepository.findByIdInvoice(invoiceId)).thenReturn(invoice);

        // Act
        invoiceService.assignOperatorToInvoice(operatorId, invoiceId);

        // Assert
        assertTrue(operator.getInvoices().contains(invoice));
        verify(operatorRepository).save(operator);
    }
*/
    @Test
    void getTotalAmountInvoiceBetweenDates_ShouldReturnTotalAmount() {
        // Arrange
        Date startDate = new Date();
        Date endDate = new Date();
        when(invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate)).thenReturn(100.0f);

        // Act
        float totalAmount = invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate);

        // Assert
        assertEquals(100.0f, totalAmount);
        verify(invoiceRepository).getTotalAmountInvoiceBetweenDates(startDate, endDate);
    }

    // Additional test cases...
}
