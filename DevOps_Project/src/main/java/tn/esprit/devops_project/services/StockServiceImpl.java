package tn.esprit.devops_project.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.dto.StockDto;
import tn.esprit.devops_project.services.iservices.IStockService;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class StockServiceImpl implements IStockService {

   private  StockRepository stockRepository;
    private Stock convertDtoToEntity(StockDto dto) {
        // create an instance of ActivitySector and set its fields using the values from the dto
        Stock entity = new Stock();
        entity.setTitle(dto.getTitle());

        // ... set other fields ...
        return entity;
    }
    @Override
    public Stock addStock(StockDto stockDto) {
        Stock stock = convertDtoToEntity(stockDto);
        return stockRepository.save(stock);
    }

    @Override
    public Stock retrieveStock(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    @Override
    public List<Stock> retrieveAllStock() {
        return stockRepository.findAll();
    }



}
