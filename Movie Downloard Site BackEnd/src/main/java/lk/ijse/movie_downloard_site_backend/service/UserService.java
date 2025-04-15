package lk.ijse.movie_downloard_site_backend.service;


import lk.ijse.movie_downloard_site_backend.dto.UserDTO;
import lk.ijse.movie_downloard_site_backend.entity.User;

import java.util.List;

public interface UserService {
    int saveUser(UserDTO userDTO);
    UserDTO searchUser(String username);
    List<User> getAlluser();
    String getUser(String token);
    User getLogUser(String token);
    void updateUser(User user);

}