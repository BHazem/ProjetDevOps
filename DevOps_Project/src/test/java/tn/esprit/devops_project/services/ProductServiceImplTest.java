package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;

import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;
import tn.esprit.devops_project.services.Iservices.IProductService;


import java.util.ArrayList;
import java.util.List;



import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

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
        assertThat(product1).isNotNull()
                .isNotEmpty();
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
        assertThat(products).isNotNull()
                .isNotEmpty();
    }

    @Autowired
    IProductService iProductService;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Test
    void retrieveProduct() {
        Product product1 = iProductService.retrieveProduct(5L);
        assertThat(product1).isNotNull();
    }

    @Test
    void retreiveAllProduct() {
        List<Product> productList = iProductService.retreiveAllProduct();
        assertThat(productList).isNotNull()
                .isNotEmpty();
    }


    @Test
    void retrieveProductByCategory() {
        List<Product> listproduct = iProductService.retrieveProductByCategory(ProductCategory.CLOTHING);
        assertThat(listproduct).isNotNull()
                .isNotEmpty();
    }


    /* @Test
    void addProduct() {
        ProductDto pdto = new ProductDto(1L, "CODE1", "IT");
        Product p = iProductService.addProduct(pdto,1L);
        assertThat(p).isNotNull();
    }
*/
    /*@Test
    void deleteProduct() {
        List<Product> productList = iProductService.retreiveAllProduct();
        iProductService.deleteProduct(productList.get(productList.size()-1).getIdProduct());
        Product product = productRepository.findById(productList.get(productList.size()-1).getIdProduct()).orElse(null);
        assertThat(product).isNull();
    }
*/
    @Test
    void retreiveProductStock() {
        List<Product> listproducts = iProductService.retreiveProductStock(1L);
        assertThat(listproducts).isNotNull()
                .isNotEmpty();
    }


}