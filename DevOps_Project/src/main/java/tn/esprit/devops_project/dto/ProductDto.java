package tn.esprit.devops_project.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.devops_project.entities.ProductCategory;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

   private Long idProduct;
   private String title;
   private float price;
   private int quantity;
   @Enumerated(EnumType.STRING)
  private ProductCategory category;

}
