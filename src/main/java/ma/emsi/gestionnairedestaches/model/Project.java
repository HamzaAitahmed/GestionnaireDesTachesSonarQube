package ma.emsi.gestionnairedestaches.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
public class Project implements Serializable {

    @Serial
    private static final long serialVersionUID = 3L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String nom;

    private String description;

    @ManyToOne
    private User projectOwner;

    @ManyToOne
    private Team projectTeam;

    @Override
    public String toString() {
        return "Project{ " +
                "id = " + id +
                " | nom = '" + nom + '\'' +
                " | Description = '" + description + '\'' +
                '}';
    }

}
