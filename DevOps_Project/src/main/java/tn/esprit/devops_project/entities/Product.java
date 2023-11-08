package tn.esprit.devops_project.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProduct;
    String title;
    float price;
    int quantity;
    @Enumerated(EnumType.STRING)
    ProductCategory category;
    @ManyToOne
    @JsonIgnore
    Stock stock;

    public Product(Long id,String p1, float v, int i, ProductCategory productCategory) {
        this.idProduct=id;
        this.title = p1;
        this.price = v;
        this.quantity = i;
        this.category = productCategory;
    }

    public Product(long l, String code1, String it, Object o) {
    }
}