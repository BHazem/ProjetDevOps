package tn.esprit.devops_project.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockDto {
   private  long idStock;
   private String title;
}
