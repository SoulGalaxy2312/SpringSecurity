package chapter3.ch3_ex1.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import chapter3.ch3_ex1.model.User;

@Configuration
public class ProjectConfig {
    @Bean   // Create a bean type UserDetailsService
    public UserDetailsService userDetailsService() {
        UserDetails u = new User("john", "12345", "read");
        List<UserDetails> users = List.of(u);
        return new InMemoryUserDetailsManager(users);
    }

    @Bean   // Create a bean type PasswordEncoder
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }    

    // Authentication Provider uses 2 interfaces
    // 1. UserDetailsService, which is the first bean
    // 2. PasswordEncoder, which is the second bean
}
