package com.example.authorizationserver.configurations;

import com.example.authorizationserver.entities.User;
import com.example.authorizationserver.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public CommandLineRunner dataLoader(PasswordEncoder encoder, UserRepository userRepo) {
        return args -> {
            userRepo.save(new User("admin", encoder.encode("admin"), "ROLE_ADMIN"));
            userRepo.save(new User("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
        };
    }
}
