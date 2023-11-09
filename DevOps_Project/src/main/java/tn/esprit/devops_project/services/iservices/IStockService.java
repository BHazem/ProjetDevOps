package tn.esprit.devops_project.services.iservices;

import tn.esprit.devops_project.dto.StockDto;
import tn.esprit.devops_project.entities.Stock;

import java.util.List;

public interface IStockService {

    Stock addStock(StockDto stockDto);
    Stock retrieveStock(Long id);
    List<Stock> retrieveAllStock();

}
