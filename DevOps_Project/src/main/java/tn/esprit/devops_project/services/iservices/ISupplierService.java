package tn.esprit.devops_project.services.iservices;

import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;

import java.util.List;

public interface ISupplierService {

	List<Supplier> retrieveAllSuppliers();

	Supplier addSupplier(SupplierDto supplierDto);

	void deleteSupplier(Long id);

	Supplier updateSupplier(SupplierDto supplierDto);

	Supplier retrieveSupplier(Long id);

}
