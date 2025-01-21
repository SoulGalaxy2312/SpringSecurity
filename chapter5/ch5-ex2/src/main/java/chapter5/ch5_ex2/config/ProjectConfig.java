package chapter5.ch5_ex2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import chapter5.ch5_ex2.filters.AuthenticationLoggingFilter;

@Configuration
public class ProjectConfig {
    
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.addFilterAfter(
            new AuthenticationLoggingFilter(), BasicAuthenticationFilter.class)
            .authorizeRequests(c -> c.anyRequest().permitAll());

        return http.build();
    }
}
