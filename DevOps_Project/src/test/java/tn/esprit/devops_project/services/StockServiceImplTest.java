package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.services.Iservices.IStockService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {

    @Autowired
    IStockService iStockService;

    @Test
    public void testretrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        Assertions.assertEquals(0, stocks.size());
    }
}