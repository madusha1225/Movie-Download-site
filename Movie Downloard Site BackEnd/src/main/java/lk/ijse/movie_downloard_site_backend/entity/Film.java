package lk.ijse.movie_downloard_site_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    //@Column(length = 45,nullable = false)
    @NotBlank(message = "fill all details")
    private String name;
    @Column(name = "year")
    private Integer year;
//    @Column(name = "genre")
//    private String genre;
    @Column(name = "description")
    private String description;
    @Column(name = "filmLink")
    private String filmLink;
    @Column(name = "movieImage")
    private String movieImage;
    @Column(name = "languages")
    private String languages;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Film(String name, Integer year, String description, String movieImage, String languages) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.movieImage = movieImage;
        this.languages = this.languages;
    }

    public Film(String name, Integer year, String description, String filmLink, String movieImage, String languages) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.filmLink = filmLink;
        this.movieImage = movieImage;
        this.languages = languages;
    }

    public Film(int id, String name, Integer year, String description, String filmLink, String movieImage, String languages) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.description = description;
        this.filmLink = filmLink;
        this.movieImage = movieImage;
        this.languages = languages;
    }
}
