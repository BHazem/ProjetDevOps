package tn.esprit.devops_project.services.Iservices;

import tn.esprit.devops_project.dto.OperatorDto;
import tn.esprit.devops_project.entities.Operator;

import java.util.List;


public interface IOperatorService {

	List<Operator> retrieveAllOperators();

	Operator addOperator(OperatorDto operator);

	void deleteOperator(Long id);

	Operator updateOperator(OperatorDto operator);

	Operator retrieveOperator(Long id);

}
