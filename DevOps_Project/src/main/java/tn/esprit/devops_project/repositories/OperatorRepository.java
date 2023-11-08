package tn.esprit.devops_project.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.devops_project.entities.Operator;
import tn.esprit.devops_project.entities.Stock;

public interface OperatorRepository extends CrudRepository<Operator, Long> {

    Operator findByIdOperateur(Long IdOperateur);


}
