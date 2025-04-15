package lk.ijse.movie_downloard_site_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

//    @NotBlank(message = "fill all details")
    private String name;
//    @NotBlank(message = "fill all details")
    private String content;
    private int filmId;
}