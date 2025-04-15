package lk.ijse.movie_downloard_site_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FilmDTO {
    private Integer id;
    private String name;
    private Integer year;
//    private String genre;
    private String description;
    private String filmLink;
    private String movieImage;
    private String languages;
    private String category;

    public FilmDTO(String name, Integer year, String description, String filmLink, String movieImage, String languages, String category) {
        this.name = name;
        this.year = year;
        this.description = description;
        this.filmLink = filmLink;
        this.movieImage = movieImage;
        this.languages = languages;
        this.category = category;
    }
}
