package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;

import tn.esprit.devops_project.entities.ProductCategory;
import tn.esprit.devops_project.entities.Stock;
import tn.esprit.devops_project.repositories.ProductRepository;
import tn.esprit.devops_project.repositories.StockRepository;


import java.util.ArrayList;
import java.util.List;



import static org.assertj.core.api.Assertions.assertThat;



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

    @Mock
    private StockRepository stockRepository;

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

    @Test
    void addProduct() {
        Stock s = new Stock();
        s.setIdStock(1L);
        // Create a mock operator
        Product product = new Product(1L, "regg", 50f, 4, ProductCategory.CLOTHING);

        // Stub the behavior of the mocked repository when saving an operator
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(stockRepository.findByIdStock(Mockito.anyLong())).thenReturn(s);

        Product result = iProductService.addProduct(product,1L);

        assertThat(result).isNotNull();
    }
   @Test
    void deleteProduct() {
       Long ProductId = 1L;
        iProductService.deleteProduct(ProductId);
       Mockito.verify(productRepository, Mockito.times(1)).deleteById(ProductId);
   }

    @Test
    void retrieveProduct() {
        Product product = new Product(2L, "regg", 50f, 4, ProductCategory.CLOTHING);

        Mockito.when(iProductService.retrieveProduct(Mockito.any())).thenReturn(product);

        Product product1 = iProductService.retrieveProduct(2L);
        assertThat(product1.getIdProduct()).isEqualTo(2L);
        assertThat(product1).isNotNull();
    }

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