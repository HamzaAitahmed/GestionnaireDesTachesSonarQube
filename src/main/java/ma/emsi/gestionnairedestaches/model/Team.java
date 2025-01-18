package ma.emsi.gestionnairedestaches.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class Team implements Serializable {

    @Serial
    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true)
    private String nom;

    @ManyToOne
    private User leader;

    @OneToMany(mappedBy = "projectTeam")
    private Collection<Project> projects;

    @ManyToMany
    private  Collection<User> members;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
    
}
