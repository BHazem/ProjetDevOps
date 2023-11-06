package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;

import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IProductService;


import java.util.ArrayList;
import java.util.List;



import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

   List<Product> productList = new ArrayList<Product>() {
        {
            add(new Product(1L, "regg", 50f, 4, ProductCategory.CLOTHING));
            add(new Product(2L, "edfef", 40f, 5, ProductCategory.CLOTHING));
        }
    };

    @InjectMocks
    private ProductServiceImpl iProductServicee;
    @Mock
    private ProductRepository productRepositoryy;

    @Mock
    private StockRepository stockRepositoryy;

    @Test
    void retreiveAllProductMock() {
        Mockito.when(iProductServicee.retreiveAllProduct()).thenReturn(productList);
        List<Product> list = iProductServicee.retreiveAllProduct();
        Assertions.assertNotNull(list);
    }


    @Test
    void retrieveProductByCategoryMock() {
        Mockito.when(iProductServicee.retrieveProductByCategory(Mockito.any())).thenReturn(productList);
        List<Product> product1 = iProductServicee.retrieveProductByCategory(ProductCategory.CLOTHING);
        assertThat(product1).isNotNull();
        assertThat(product1).isNotEmpty();
    }

    @Test
    void addProductMock() {
        Stock s = new Stock();
        s.setIdStock(1L);
        // Create a mock operator
        Product product = new Product(1L, "regg", 50f, 4, ProductCategory.CLOTHING);

        // Stub the behavior of the mocked repository when saving an operator
        Mockito.when(productRepositoryy.save(product)).thenReturn(product);
        Mockito.when(stockRepositoryy.findByIdStock(Mockito.anyLong())).thenReturn(s);

        Product result = iProductServicee.addProduct(product,1L);

        assertThat(result).isNotNull();
    }
   @Test
    void deleteProductMock() {
       Long ProductId = 1L;
        iProductServicee.deleteProduct(ProductId);
       Mockito.verify(productRepositoryy, Mockito.times(1)).deleteById(ProductId);
   }

    @Test
    void retrieveProductMock() {
        Product product = new Product(2L, "regg", 50f, 4, ProductCategory.CLOTHING);

        Mockito.when(iProductServicee.retrieveProduct(Mockito.any())).thenReturn(product);

        Product product1 = iProductServicee.retrieveProduct(2L);
        assertThat(product1.getIdProduct()).isEqualTo(2L);
        assertThat(product1).isNotNull();
    }

    @Test
    void retrieveProductStockMock() {

        Mockito.when(iProductServicee.retreiveProductStock(Mockito.anyLong())).thenReturn(productList);

        List<Product> products = iProductServicee.retreiveProductStock(1L);
        assertThat(products).isNotNull();
        assertThat(products).isNotEmpty();
    }

 @Autowired
  IProductService iProductService;

 @Autowired
 ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Test
    void retrieveProduct() {
    Product product1 = iProductService.retrieveProduct(1L);
    assertThat(product1).isNotNull();
    }

    @Test
    void retreiveAllProduct() {
        List<Product> productList = iProductService.retreiveAllProduct();
        assertThat(productList).isNotNull();
        assertThat(productList).isNotEmpty();
    }


    @Test
    void retrieveProductByCategory() {
        List<Product> listproduct = iProductService.retrieveProductByCategory(ProductCategory.CLOTHING);
        assertThat(listproduct).isNotNull();
        assertThat(listproduct).isNotEmpty();
    }


    @Test
    void addProduct() {
        Product product = new Product().builder().price(50f).quantity(5).category(ProductCategory.CLOTHING).title("Souris").build();
        Product p = iProductService.addProduct(product,1L);
        assertThat(p).isNotNull();
    }

    /*@Test
    void deleteProduct() {
        iProductService.deleteProduct(9L);
        Product product = productRepository.findById(9L).orElse(null);
        assertThat(product).isNull();
    }*/

    @Test
    void retreiveProductStock() {
        List<Product> listproducts = iProductService.retreiveProductStock(1L);
        assertThat(listproducts).isNotNull();
        assertThat(listproducts).isNotEmpty();
    }


}