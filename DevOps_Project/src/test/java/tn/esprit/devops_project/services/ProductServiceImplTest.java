package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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
import tn.esprit.devops_project.services.Iservices.IProductService;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@SpringBootTest
class ProductServiceImplTest {

    List<Product> productList = new ArrayList<Product>() {
        {
            add(new Product(1L, "regg", 50f, 4, ProductCategory.CLOTHING));
            add(new Product(2L, "edfef", 40f, 5, ProductCategory.CLOTHING));
        }
    };

    @InjectMocks
    private ProductServiceImpl iProductService;
    @Mock
    private ProductRepository productRepository;



    @Test
    void retreiveAllProduct() {
        Mockito.when(iProductService.retreiveAllProduct()).thenReturn(productList);
        List<Product> list = iProductService.retreiveAllProduct();
        Assertions.assertNotNull(list);
    }


    @Test
    void retrieveProductByCategory() {
        Product product = new Product(1L, "regg", 50f, 4, ProductCategory.CLOTHING);

        Mockito.when(iProductService.retrieveProductByCategory(Mockito.any())).thenReturn(productList);

        List<Product> product1 = iProductService.retrieveProductByCategory(ProductCategory.CLOTHING);
        assertThat(product1).isNotNull();
        assertThat(product1).isNotEmpty();
    }

      /*@Test
    void addProduct() {
        Product product = new Product(1L, "regg", 50f, 4, ProductCategory.CLOTHING);
        when(iProductService.addProduct(eq(product), anyLong())).thenReturn(product);
        Product p = iProductService.addProduct(product, 1L);
        assertThat(p).isNotNull();
    }

  @Test
    void deleteProduct() {
        when(productRepository.findById(1L)).thenReturn(Optional.empty());

        iProductService.deleteProduct(1L);

        Product product = productRepository.findById(1L).orElse(null);
        assertThat(product).isNull();
    }*/

    @Test
    void retrieveProductStock() {
        Product product = new Product(1L, "regg", 50f, 4, ProductCategory.CLOTHING);

        Mockito.when(iProductService.retreiveProductStock(Mockito.anyLong())).thenReturn(productList);

        List<Product> products = iProductService.retreiveProductStock(1L);
        assertThat(products).isNotNull();
        assertThat(products).isNotEmpty();
    }
 /*@Autowired
 IProductService iProductService;

 @Autowired
 ProductRepository productRepository;


    @Test
    void retrieveProduct() {
    Product product = new Product().builder().idProduct(10L).title("Souris").build();
    Product product1 = iProductService.retrieveProduct(10L);
    assertThat(product1.getIdProduct()).isEqualTo(10L);
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

    @Test
    void deleteProduct() {
        iProductService.deleteProduct(9L);
        Product product = productRepository.findById(9L).orElse(null);
        assertThat(product).isNull();
    }

    @Test
    void retreiveProductStock() {
        List<Product> listproducts = iProductService.retreiveProductStock(1L);
        assertThat(listproducts).isNotNull();
        assertThat(listproducts).isNotEmpty();
    }*/


}