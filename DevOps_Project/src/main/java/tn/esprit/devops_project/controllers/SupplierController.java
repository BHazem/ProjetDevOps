package tn.esprit.devops_project.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.entities.Supplier;
import tn.esprit.devops_project.services.Iservices.ISupplierService;
import java.util.List;


@RestController
@AllArgsConstructor
@CrossOrigin(origins = "http://192.168.176.160:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SupplierController {

	ISupplierService supplierService;
@CrossOrigin(origins = "http://192.168.176.160:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

	@GetMapping("/supplier")
	public List<Supplier> getSuppliers() {
		return supplierService.retrieveAllSuppliers();
	}
@CrossOrigin(origins = "http://192.168.176.160:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

	@GetMapping("/supplier/{supplierId}")
	public Supplier retrieveSupplier(@PathVariable Long supplierId) {
		return supplierService.retrieveSupplier(supplierId);
	}
@CrossOrigin(origins = "http://192.168.176.160:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

	@PostMapping("/supplier")
	public Supplier addSupplier(@RequestBody Supplier supplier) {
		return supplierService.addSupplier(supplier);
	}
@CrossOrigin(origins = "http://192.168.176.160:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

	@DeleteMapping("/supplier/{supplierId}")
	public void removeFournisseur(@PathVariable Long supplierId) {
		supplierService.deleteSupplier(supplierId);
	}
@CrossOrigin(origins = "http://192.168.176.160:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

	@PutMapping("/supplier")
	public Supplier modifyFournisseur(@RequestBody Supplier supplier) {
		return supplierService.updateSupplier(supplier);
	}

}
