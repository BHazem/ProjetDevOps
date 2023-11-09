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
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import tn.esprit.devops_project.dto.ActivitySectorDto;
import tn.esprit.devops_project.dto.StockDto;
import tn.esprit.devops_project.entities.ActivitySector;
import tn.esprit.devops_project.entities.Stock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import tn.esprit.devops_project.repositories.StockRepository;

import static org.assertj.core.api.Assertions.as;
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

    @Test
    void addStock_ShouldReturnNewStock() {
        // Arrange
        StockDto stockDto = new StockDto(); // Assume StockDto is properly set up
        Stock stock = new Stock(); // Assume Stock is properly set up
        when(stockRepository.save(any(Stock.class))).thenReturn(stock);

        // Act
        Stock result = stockService.addStock(stockDto);

        // Assert
        assertNotNull(result);
        verify(stockRepository).save(any(Stock.class));
    }

    @Test
    void retrieveStock_ShouldReturnStock() {
        Stock result = stockRepository.findByIdStock(7L);
        assertThat(result).isNotNull();
    }

    @Test
    void retrieveAllStock_ShouldReturnStockList() {
        // Arrange
        when(stockRepository.findAll()).thenReturn(Collections.singletonList(new Stock()));

        // Act
        List<Stock> result = stockService.retrieveAllStock();

        // Assert
        assertFalse(result.isEmpty());
        verify(stockRepository).findAll();
    }
   /* @InjectMocks
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
    private Stock convertDtoToEntity(StockDto dto) {
        // create an instance of ActivitySector and set its fields using the values from the dto
        Stock entity = new Stock();
        entity.setIdStock(dto.getIdStock());
        entity.setTitle(dto.getTitle());

        // ... set other fields ...
        return entity;
    }
  */  @Test
    void testAddStockMoch(){
        StockDto stock2 =new StockDto(4L,"test4");
        Stock savedStock = stockService.addStock(stock2);
        assertThat(savedStock).isNotNull();
    }









    @Autowired
    StockServiceImpl iStockService;

    @Test
    void testretrieveAllStock(){
        List<Stock> stocks = iStockService.retrieveAllStock();
        assertThat(stocks).isNotNull();
    }
    /* @Test
    void retrieveStock(){
        Stock stock1 = stockService.retrieveStock(2L);
        assertThat(stock1).isNotNull();
    }
*/


}