package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.dto.InvoiceDto;
import tn.esprit.devops_project.entities.Invoice;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.InvoiceDetailRepository;
import tn.esprit.devops_project.repositories.InvoiceRepository;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.iservices.IInvoiceService;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class InvoiceServiceImpl implements IInvoiceService {

	final InvoiceRepository invoiceRepository;
	final OperatorRepository operatorRepository;
	final InvoiceDetailRepository invoiceDetailRepository;
	final SupplierRepository supplierRepository;
	private static final String X1 = "Invoice not found";  // Compliant

	//commentaire
	//commentaire 2 developper
	@Override
	public List<Invoice> retrieveAllInvoices() {
		return invoiceRepository.findAll();
	}


	@Override
	public Invoice addInvoice(InvoiceDto invoiceDto) {
		Invoice invoice = convertDtoToEntity(invoiceDto);
		return invoiceRepository.save(invoice);
	}


	private Invoice convertDtoToEntity(InvoiceDto dto) {
		// create an instance of ActivitySector and set its fields using the values from the dto
		Invoice entity = new Invoice();
		entity.setArchived(dto.getArchived());
		entity.setAmountInvoice(dto.getAmountDiscount());
		entity.setDateCreationInvoice(dto.getDateCreationInvoice());
		entity.setAmountInvoice(dto.getAmountInvoice());
		entity.setArchived(dto.getArchived());

		// ... set other fields ...
		return entity;
	}
	@Override
	public void cancelInvoice(Long invoiceId) {
		// method 01
		Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(() -> new NullPointerException(X1));
		invoice.setArchived(true);
		invoiceRepository.save(invoice);
		//method 02 (Avec JPQL)
		invoiceRepository.updateInvoice(invoiceId);
	}

	@Override
	public Invoice retrieveInvoice(Long invoiceId) {

		return invoiceRepository.findById(invoiceId).orElseThrow(() -> new NullPointerException(X1));
	}

	@Override
	public List<Invoice> getInvoicesBySupplier(Long idSupplier) {
		Supplier supplier = supplierRepository.findById(idSupplier).orElseThrow(() -> new NullPointerException("Supplier not found"));
		return (List<Invoice>) supplier.getInvoices();
	}

	@Override
	public void assignOperatorToInvoice(Long idOperator, Long idInvoice) {
		Invoice invoice = invoiceRepository.findByIdInvoice(idInvoice);
		Operator operator = operatorRepository.findByIdOperateur(idOperator);
		operator.getInvoices().add(invoice);
		operatorRepository.save(operator);
	}

	@Override
	public float getTotalAmountInvoiceBetweenDates(Date startDate, Date endDate) {
		return invoiceRepository.getTotalAmountInvoiceBetweenDates(startDate, endDate);
	}


}