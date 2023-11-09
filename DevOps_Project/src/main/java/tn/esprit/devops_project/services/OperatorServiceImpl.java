package tn.esprit.devops_project.services;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.dto.OperatorDto;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.repositories.OperatorRepository;
import tn.esprit.devops_project.services.iservices.IOperatorService;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatorServiceImpl implements IOperatorService {

	OperatorRepository operatorRepository;
	@Override
	public List<Operator> retrieveAllOperators() {
		return (List<Operator>) operatorRepository.findAll();
	}

	@Override
	public Operator addOperator(OperatorDto operatorDto) {
		Operator   operatorr = convertDtoToEntity(operatorDto);
		return operatorRepository.save(operatorr);
	}

	private Operator convertDtoToEntity(OperatorDto dto) {
		// create an instance of ActivitySector and set its fields using the values from the dto
		Operator entity = new Operator();
		entity.setIdOperateur(dto.getIdOperateur());
		entity.setFname(dto.getFname());
		entity.setLname(dto.getLname());
		entity.setPassword(dto.getPassword());
		// ... set other fields ...
		return entity;
	}
	@Override
	public void deleteOperator(Long id) {
		operatorRepository.deleteById(id);
		
	}

	@Override
	public Operator updateOperator(OperatorDto operatorDto) {
		Operator   operator = convertDtoToEntity(operatorDto);

		return operatorRepository.save(operator);
	}

	@Override
	public Operator retrieveOperator(Long id) {
		return operatorRepository.findById(id).orElseThrow(() -> new NullPointerException("Operator not found"));
	}

}
