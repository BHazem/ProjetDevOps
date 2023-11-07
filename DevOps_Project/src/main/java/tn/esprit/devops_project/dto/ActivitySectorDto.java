package tn.esprit.devops_project.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ActivitySectorDto {

    private Long idSecteurActivite;
    private String codeSecteurActivite;
    private   String libelleSecteurActivite;
}
