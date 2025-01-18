package ma.emsi.gestionnairedestaches.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;

    @Column(unique=true)
    private String email;

    private String password;

    @Column(name = "photo", nullable = true)
    private String profilePicture;

    @OneToMany(mappedBy = "projectOwner")
    private Collection<Project> projects;

    @ManyToMany(mappedBy = "members")
    private Collection<Team> teams;

    public User(String email, String password, String username) {
        this.email = email;
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", profilePicture='" + profilePicture + '\'' +
                '}';
    }
}
