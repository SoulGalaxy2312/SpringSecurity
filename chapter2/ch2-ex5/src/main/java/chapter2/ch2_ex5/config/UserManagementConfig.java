package chapter2.ch2_ex5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class UserManagementConfig {
    @Bean
    UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        UserDetails user = User.withUsername("user")
                                .password("12345")
                                .authorities("read")
                                .build();

        userDetailsService.createUser(user);
        return userDetailsService;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
