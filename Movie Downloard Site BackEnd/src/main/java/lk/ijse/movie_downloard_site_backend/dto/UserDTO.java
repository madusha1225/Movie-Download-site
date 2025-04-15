package lk.ijse.movie_downloard_site_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String name;
    private String role;
    private String email;
    private String password;
    private String subscription_plan;

    public UserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
