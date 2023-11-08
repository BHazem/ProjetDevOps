package tn.esprit.devops_project.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;
import tn.esprit.devops_project.entities.SupplierCategory;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class SupplierDto { private Long idSupplier;
  private  String code;
  private String label;
  @Enumerated(EnumType.STRING)
  private SupplierCategory supplierCategory;
}
