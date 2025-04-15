package lk.ijse.movie_downloard_site_backend.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {
    @Bean
    public ModelMapper ModelMapper(){
        return new ModelMapper();
    }
}
