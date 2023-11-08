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
import tn.esprit.devops_project.entities.Stock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import tn.esprit.devops_project.repositories.StockRepository;
import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
        assertThat(stock1.getIdStock()).isEqualTo(2L);
        assertThat(stock1).isNotNull();
    }


 /*   @Test
    void testRetrieveStock() {
        Long stockId = 1L; // ID de stock à récupérer

        // Configurez le comportement du mock pour la méthode du dépôt
        Mockito.when(stockRepository.findById(stockId)).thenReturn(Optional.of(stock));

        Stock result = stockService.retrieveStock(stockId);

        // Vérifiez que la méthode du service appelle la méthode du dépôt
        Mockito.verify(stockRepository).findById(stockId);

        // Vérifiez que le résultat de la méthode du service est le même que le mock de la méthode du dépôt
        assertEquals(stock, result);
    }

Stock stock1=new Stock(2L,"aaa");
        Mockito.when(stockService.retrieveStock(Mockito.any())).thenReturn(stock1);
        Stock stock2 =stockService.retrieveStock(2L);
        assertThat(stock2.getIdStock()).isEqualTo(2L);
        assertThat(stock2).isNotNull();

        Mockito.when(stockRepository.findById(2L))
                .thenReturn(Optional.of(stock));
        Stock stock1 =stockService.retrieveStock(2L);
        Assertions.assertNotNull(stock1);
        Assertions.assertEquals(stock, stock1);

        Mockito.when(stockRepository.findById(4L)).thenReturn(Optional.empty());

        Stock stock2 = stockService.retrieveStock(4L);

        Assertions.assertNull(stock2);*/






/*
    @Autowired
    StockServiceImpl iStockService;

    @Test
    void testretrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        assertThat(stocks).isNotNull();
        assertThat(stocks).isNotEmpty();
    }*/


}