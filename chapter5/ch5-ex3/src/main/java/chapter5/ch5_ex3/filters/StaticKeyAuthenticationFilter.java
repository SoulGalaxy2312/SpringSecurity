package chapter5.ch5_ex3.filters;

import java.io.IOException;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class StaticKeyAuthenticationFilter implements Filter {
    Logger logger = Logger.getLogger(StaticKeyAuthenticationFilter.class.getName());

    @Value("${authorization.key}")
    private String authorizationKey;
    
    @Override
    public void doFilter(
        ServletRequest request,
        ServletResponse response,
        FilterChain filterChain
    ) throws IOException, ServletException {

        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        String authentication = httpRequest.getHeader("Authorization");

        if (authentication == null || !authentication.equals(this.authorizationKey)) {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            logger.info("Received: " + authentication + "\nExpected: " + authorizationKey);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
