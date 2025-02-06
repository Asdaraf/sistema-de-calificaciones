package com.edutecno.sistemacalificacionesapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Deshabilitar CSRF para pruebas
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()  // Permitir todas las rutas API sin autenticación
            );
        return http.build();
    }
}
