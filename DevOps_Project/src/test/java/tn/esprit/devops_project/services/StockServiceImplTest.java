package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.entities.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tn.esprit.devops_project.repositories.StockRepository;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(MockitoExtension.class)

class StockServiceImplTest {

    @InjectMocks
    private StockServiceImpl stockService;

    @Mock
    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    Stock stock = new Stock(1L,"qqq");
    List<Stock> stockList= new ArrayList<Stock>(){
        {
            add(new Stock(2L,"aaa"));
            add(new Stock(3L, "bbb"));
        }
    };
    @Test
     void  testretrieveAllStockMock() {
        Mockito.when(stockService.retrieveAllStock()).thenReturn(stockList);
        List<Stock> list = stockService.retrieveAllStock();
        Assertions.assertNotNull(list);
    }

    @Test
    void testretrievestochMock(){
        Stock stock = new Stock(2L,"qqq");
        Mockito.when(stockService.retrieveStock(Mockito.any())).thenReturn(stock);
        Stock stock1 =stockService.retrieveStock(2L);
        assertThat(stock1.getIdStock()).isEqualTo(2L)
       .isNotNull();
    }
    @Test
    void testAddStockMoch(){
        Stock stock2 =new Stock(4L,"test4");
        Mockito.when(stockService.addStock(Mockito.any())).thenReturn(stock2);
        Stock savedStock = stockService.addStock(stock2);
        assertThat(savedStock).isNotNull();
        assertThat(savedStock.getIdStock()).isEqualTo(4L);
        assertThat(savedStock.getTitle()).isEqualTo("test4");
    }







/*

    @Autowired
    StockServiceImpl iStockService;

    @Test
    void testretrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        assertThat(stocks).isNotNull();
        assertThat(stocks).isNotEmpty();
    }
    @Test
    void retrieveStock(){
        Stock stock1 = stockService.retrieveStock(1L);
        assertThat(stock1).isNotNull();
    }
*/


}