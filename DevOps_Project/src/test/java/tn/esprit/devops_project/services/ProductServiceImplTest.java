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





 @Autowired
 IProductService iProductService;

 @Autowired
 ProductRepository productRepository;


    @Test
    void retrieveProduct() {
    Product product = new Product().builder().idProduct(4L).title("Souris").build();
    Product product1 = iProductService.retrieveProduct(4L);
    assertThat(product1.getIdProduct()).isEqualTo(4L);
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
        iProductService.deleteProduct(5L);
        Product product = productRepository.findById(5L).orElse(null);
        assertThat(product).isNull();
    }*/

    @Test
    void retreiveProductStock() {
        List<Product> listproducts = iProductService.retreiveProductStock(1L);
        assertThat(listproducts).isNotNull();
        assertThat(listproducts).isNotEmpty();
    }


}