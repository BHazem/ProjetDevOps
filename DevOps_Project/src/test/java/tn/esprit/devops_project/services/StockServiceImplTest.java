package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.services.Iservices.IStockService;

import java.util.ArrayList;
import java.util.List;
import tn.esprit.devops_project.repositories.StockRepository;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StockServiceImplTest {


   /* List<Stock> StockList = new ArrayList<Stock>() {
        {
            add(new Stock(1L, "stock1"));
            add(new Stock(2L, "stock2"));
        }
    };*/
/*
    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @Test
    public void  retrieveAllStock(){
        Long idStock = 1L;

        Stock stock =new Stock();
        stock.setTitle("title1");

        Mockito.when(stockRepository.save(Mockito.any(Stock.class)))
                .thenReturn(stock);
        List<Stock> list =stockService.retrieveAllStock();
        assertEquals("title1", stock.getTitle());
        Assertions.assertNotNull(list);
    }

*/



    @Autowired
    IStockService iStockService;

    @Test
    public void testretrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        Assertions.assertEquals(0, stocks.size());
    }
}