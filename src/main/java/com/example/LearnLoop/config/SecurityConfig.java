package com.example.LearnLoop.config;

import com.example.LearnLoop.security.JwtAuthenticationFilter;
import com.example.LearnLoop.security.JwtUtil;
import com.example.LearnLoop.security.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final CustomUserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public SecurityConfig(CustomUserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())  // Disable CSRF for API access
            .authorizeHttpRequests(auth -> auth
            
                .requestMatchers(
                    
                "/api/auth/login/**",     // Allow authentication endpoints
                    "/api/instructors/**", // Allow instructor registration
                    "/api/students/**",    // Allow student registration
                    "/api/payment/**",
                    "/api/lesson/**",
                    "/api/enrollment/**",
                    "/api/courses/**",
                    "/api/reviews/**",
                    "/api/videos/**",
                    "/api/contact/send",
                    "/api/contact",
                    "/v3/api-docs/**",  // Allow Swagger API docs
                    "/swagger-ui/**",   // Allow Swagger UI
                    "/swagger-ui.html"  // Allow Swagger UI HTML page
                ).permitAll()
                
                .anyRequest().authenticated()  // Require authentication for all other requests
            )
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .addFilterBefore(new JwtAuthenticationFilter(jwtUtil, userDetailsService), 
                             UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
