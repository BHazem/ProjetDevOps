package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;

import java.util.List;
import org.junit.jupiter.api.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductServiceImplTestSql {
    @Autowired
    private ProductServiceImpl iProductService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

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
    void retreiveProductStock() {
        List<Product> listproducts = iProductService.retreiveProductStock(1L);
        assertThat(listproducts).isNotNull();
        assertThat(listproducts).isNotEmpty();
    }
}