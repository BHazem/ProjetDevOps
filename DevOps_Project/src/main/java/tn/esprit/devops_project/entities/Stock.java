package tn.esprit.devops_project.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idStock;
    String title;
    @OneToMany(mappedBy = "stock")
     private Set<Product> products;



    public Stock(long idStock, String title) {
        super();
        this.idStock = idStock;
        this.title = title;
    }

    public long getIdStock() {
        return idStock;
    }

    public String getTitle() {
        return title;
    }
}
