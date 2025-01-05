package chapter2.ch2_ex4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import chapter2.ch2_ex4.security.CustomAuthenticationProvider;

@Configuration
public class ProjectConfig {
    private final CustomAuthenticationProvider authenticationProvider;

    public ProjectConfig(
        CustomAuthenticationProvider customAuthenticationProvider
    ) {

        this.authenticationProvider = customAuthenticationProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity httpSecurity)
        throws Exception { 
        
        httpSecurity.httpBasic(Customizer.withDefaults());
            
        httpSecurity.authenticationProvider(this.authenticationProvider);
        
        httpSecurity.authorizeHttpRequests(
            c -> c.anyRequest().authenticated()
        );

        return httpSecurity.build();
    }
}
