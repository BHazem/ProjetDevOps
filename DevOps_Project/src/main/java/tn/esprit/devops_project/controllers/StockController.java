package tn.esprit.devops_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.devops_project.dto.StockDto;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.services.iservices.IStockService;
import java.util.List;

//@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class StockController {

    IStockService stockService;

    @PostMapping("/stock")
    Stock addStock(@RequestBody StockDto stockDto){
        return stockService.addStock(stockDto);
    }

    @GetMapping("/stock/{id}")
    Stock retrieveStock(@PathVariable Long id){
        return stockService.retrieveStock(id);
    }

    @GetMapping("/stock")
    List<Stock> retrieveAllStock(){
        return stockService.retrieveAllStock();
    }

    @DeleteMapping("/stockDelete/{id}")
    void deleteStock(@PathVariable Long id){
        stockService.deleteStock(id);
    }

}
