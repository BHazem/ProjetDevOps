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
        private Long idInvoice;
        private float amountDiscount;
        private float amountInvoice;
        @Temporal(TemporalType.DATE)
        private Date dateCreationInvoice;
        @Temporal(TemporalType.DATE)
        private Date dateLastModificationInvoice;
        private Boolean archived;





}
