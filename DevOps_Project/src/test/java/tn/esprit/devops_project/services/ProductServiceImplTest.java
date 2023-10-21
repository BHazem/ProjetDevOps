package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.devops_project.entities.Product;
import tn.esprit.devops_project.services.Iservices.IProductService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class ProductServiceImplTest {


    @Autowired
    IProductService iProductService;

    @Test
    public void retreiveAllProduct() {
        List<Product> listProducts = iProductService.retreiveAllProduct();
        Assertions.assertEquals(0,listProducts.size());
    }

}