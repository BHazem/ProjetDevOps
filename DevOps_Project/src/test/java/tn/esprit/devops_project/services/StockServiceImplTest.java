package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.dto.StockDto;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.Stock;

import java.util.Collections;
import java.util.List;

import tn.esprit.devops_project.repositories.StockRepository;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StockServiceImplTest {

    @Mock
    private StockRepository stockRepository;

    @InjectMocks
    private StockServiceImpl stockService;

    @Autowired
    private StockRepository stockRepositoryy;

    @Autowired
    private StockServiceImpl stockServicee;

    @Test
    void addStock_ShouldReturnNewStock() {
        StockDto stockDto = new StockDto();
        Stock stock = new Stock();
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);
        Stock result = stockService.addStock(stockDto);
        assertNotNull(result);
        verify(stockRepository).save(any(Stock.class));
    }

    @Test
    void retrieveStock_ShouldReturnStock() {
        Stock result = stockServicee.retrieveStock(1L);
        assertThat(result).isNotNull();
    }

    @Test
    void retrieveAllStock_ShouldReturnStockList() {
        when(stockRepository.findAll()).thenReturn(Collections.singletonList(new Stock()));
        List<Stock> result = stockService.retrieveAllStock();
        assertFalse(result.isEmpty());
        verify(stockRepository).findAll();
    }

  @Test
    void testAddStockMoch(){
        StockDto stock2 =new StockDto();
        stock2.setTitle("hazem");
        Stock savedStock = stockServicee.addStock(stock2);
        assertThat(savedStock).isNotNull();
    }




    @Autowired
    StockServiceImpl iStockService;

    @Test
    void testretrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        assertThat(stocks).isNotNull();
    }

     @Test
    void retrieveStock(){
        Stock stock1 = iStockService.retrieveStock(2L);
        assertThat(stock1).isNotNull();
    }


    @Test
    void deleteStock() {
        List<Stock> stockList = iStockService.retrieveAllStock();
        iStockService.deleteStock(stockList.get(stockList.size()-1).getIdStock());
        Stock stock = stockRepositoryy.findById(stockList.get(stockList.size()-1).getIdStock()).orElse(null);
        assertThat(stock).isNull();
    }
}