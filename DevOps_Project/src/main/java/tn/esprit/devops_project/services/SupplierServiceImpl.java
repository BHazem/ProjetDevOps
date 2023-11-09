package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.dto.SupplierDto;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.repositories.SupplierRepository;
import tn.esprit.devops_project.services.Iservices.ISupplierService;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class SupplierServiceImpl implements ISupplierService {

	SupplierRepository supplierRepository;
	private Supplier convertDtoToEntity(SupplierDto dto) {
		// create an instance of ActivitySector and set its fields using the values from the dto
		Supplier entity = new Supplier();
		entity.setCode(dto.getCode());
		entity.setLabel(dto.getLabel());
		entity.setSupplierCategory(dto.getSupplierCategory());
		// ... set other fields ...
		return entity;
	}

	@Override
	public List<Supplier> retrieveAllSuppliers() {
		return supplierRepository.findAll();
	}


	@Override
	public Supplier addSupplier(SupplierDto supplierDto) {
		Supplier supplier= convertDtoToEntity(supplierDto);
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier updateSupplier(SupplierDto supplierDto) {
		Supplier supplier= convertDtoToEntity(supplierDto);

		return  supplierRepository.save(supplier);
	}

	@Override
	public void deleteSupplier(Long supplierId) {

		supplierRepository.deleteById(supplierId);

	}

	@Override
	public Supplier retrieveSupplier(Long supplierId) {

		return supplierRepository.findById(supplierId).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + supplierId));
	}


}