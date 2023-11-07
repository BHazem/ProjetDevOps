package tn.esprit.devops_project.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OperatorDto {
   private Long idOperateur;
   private String fname;
   private String lname;
   private String password;
}
