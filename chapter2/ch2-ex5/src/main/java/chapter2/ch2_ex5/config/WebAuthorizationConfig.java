package chapter2.ch2_ex5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebAuthorizationConfig {
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception{
        http.httpBasic(Customizer.withDefaults()); // using HTTP Basic to authenticate

        http.authorizeHttpRequests(
            // Make sure that any request must be authenticated
            c -> c.anyRequest().authenticated()
        );

        return http.build();
    }
}
