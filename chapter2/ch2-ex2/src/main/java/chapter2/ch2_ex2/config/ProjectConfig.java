package chapter2.ch2_ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {
    @Bean
    UserDetailsService userDetailsService() {
        UserDetails userDetails = User.withUsername("user")
                                        .password("12345")
                                        .authorities("read")
                                        .build();

        return new InMemoryUserDetailsManager(userDetails);
    }
}
