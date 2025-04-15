package lk.ijse.movie_downloard_site_backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email address")
    private int id;
    private String name;
    private String role;
    private String email;
    private String password;
    private String subscription_plan;
}
