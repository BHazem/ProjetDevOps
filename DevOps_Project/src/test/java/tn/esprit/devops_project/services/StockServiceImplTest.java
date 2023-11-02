package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Stock;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.devops_project.repositories.StockRepository;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {


/*
    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

   List<Stock> stockList= new ArrayList<Stock>(){
       {
           add(new Stock(1L,"aaa"));
           add(new Stock(2L, "bbb"));
       }
   };

    @Test
     void  addStock(){
        Long idStock = 1L;
        Stock stock = new Stock(1L,"aaa");

       // Stock stock =new Stock(1L, "ff");
       //stock.setTitle("title1");

        Mockito.when(stockRepository.save(stock))
                .thenReturn(stock);
       // List<Stock> list =stockService.retrieveAllStock();
        Stock result = stockService.addStock(stock);
        //assertThat(result)
    }


*/


    @Autowired
    StockServiceImpl iStockService;

    @Test
    public void testretrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        Assertions.assertEquals(0, stocks.size());
    }
}