package lk.ijse.movie_downloard_site_backend.controller;

import jakarta.validation.Valid;
import lk.ijse.movie_downloard_site_backend.dto.AuthDTO;
import lk.ijse.movie_downloard_site_backend.dto.ResponseDTO;
import lk.ijse.movie_downloard_site_backend.dto.UserDTO;
import lk.ijse.movie_downloard_site_backend.entity.User;
import lk.ijse.movie_downloard_site_backend.service.UserService;
import lk.ijse.movie_downloard_site_backend.util.JwtUtil;
import lk.ijse.movie_downloard_site_backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private ModelMapper modelMapper;

    private final UserService userService;
    private final JwtUtil jwtUtil;

    //constructor injection
    public UserController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }
    @PostMapping(value = "/register")
    public ResponseEntity<ResponseDTO> registerUser(@RequestBody @Valid UserDTO userDTO) {
        try {
            int res = userService.saveUser(userDTO);
            switch (res) {
                case VarList.Created -> {
                    String token = jwtUtil.generateToken(userDTO);
                    AuthDTO authDTO = new AuthDTO();
                    authDTO.setEmail(userDTO.getEmail());
                    authDTO.setToken(token);
                    return ResponseEntity.status(HttpStatus.CREATED)
                            .body(new ResponseDTO(VarList.Created, userDTO.getRole(), authDTO));
                }
                case VarList.Not_Acceptable -> {
                    return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
                            .body(new ResponseDTO(VarList.Not_Acceptable, "Email Already Used", null));
                }
                default -> {
                    return ResponseEntity.status(HttpStatus.BAD_GATEWAY)
                            .body(new ResponseDTO(VarList.Bad_Gateway, "Error", null));
                }
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDTO(VarList.Internal_Server_Error, e.getMessage(), null));
        }
    }

    @GetMapping(path = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserDTO> getAllUsers() {
        List<User> allUsers = userService.getAlluser();
        return allUsers.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
    @PostMapping (value = "/getoneuser")
    public String getUser(@Param("token") String token){
        return userService.getUser(token);
    }

    @PostMapping("getUser")
    public User getLoginUser(@Param("token") String token) {
        return userService.getLogUser(token);
    }

    @PutMapping("updateUser")
    public void updateUSer(@RequestBody User user) {
        userService.updateUser(user);
    }
}
