package lk.ijse.movie_downloard_site_backend.service.impl;

import lk.ijse.movie_downloard_site_backend.dto.UserDTO;
import lk.ijse.movie_downloard_site_backend.entity.User;
import lk.ijse.movie_downloard_site_backend.repo.UserRepository;
import lk.ijse.movie_downloard_site_backend.service.UserService;
import lk.ijse.movie_downloard_site_backend.util.JwtUtil;
import lk.ijse.movie_downloard_site_backend.util.VarList;
import org.antlr.v4.runtime.Token;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Transactional
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), getAuthority(user));
    }

    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }

    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }

    @Override
    public UserDTO searchUser(String username) {
        if (userRepository.existsByEmail(username)) {
            User user=userRepository.findByEmail(username);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userDTO.setSubscription_plan("Unsubscribe");
//            userDTO.setRole("USER");
            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }
    }

    @Override
    public List<User> getAlluser() {
        List<User> all = userRepository.findAll();
        return all;
    }
    @Override
    public String getUser(String token){
        String usernameFromToken = jwtUtil.getUsernameFromToken(token);
        User byEmail = userRepository.findByEmail(usernameFromToken);
        return byEmail.getSubscription_plan();
    }

    @Override
    public User getLogUser(String token) {
        String usernameFromToken = jwtUtil.getUsernameFromToken(token);
        User byEmail = userRepository.findByEmail(usernameFromToken);
        return byEmail;
    }

    @Override
    public void updateUser(User user) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
