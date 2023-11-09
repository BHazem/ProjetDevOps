package tn.esprit.devops_project.dto;
import java.util.Date;
;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class InvoiceDto {


        Long idInvoice;
        float amountDiscount;
        float amountInvoice;
        @Temporal(TemporalType.DATE)
        Date dateCreationInvoice;
        @Temporal(TemporalType.DATE)
        Date dateLastModificationInvoice;
        Boolean archived;





}
