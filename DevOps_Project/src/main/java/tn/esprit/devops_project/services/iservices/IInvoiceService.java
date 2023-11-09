package tn.esprit.devops_project.services.iservices;

import tn.esprit.devops_project.dto.ActivitySectorDto;
import tn.esprit.devops_project.dto.InvoiceDto;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.entities.Invoice;

import java.util.Date;
import java.util.List;

public interface IInvoiceService {
	List<Invoice> retrieveAllInvoices();
	Invoice addInvoice(InvoiceDto invoiceDto);

	List<Invoice> getInvoicesBySupplier(Long idSupplier);

	void cancelInvoice(Long id);

	Invoice retrieveInvoice(Long id);
	
	void assignOperatorToInvoice(Long idOperator, Long idInvoice);

	float getTotalAmountInvoiceBetweenDates(Date startDate, Date endDate);
}
