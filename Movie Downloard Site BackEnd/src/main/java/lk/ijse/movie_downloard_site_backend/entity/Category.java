package lk.ijse.movie_downloard_site_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Film> films;

    public Category(String name) {
        this.name = name;
    }
}
