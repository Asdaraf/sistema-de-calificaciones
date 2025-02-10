package com.edutecno.sistemacalificacionesfrontend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf(csrf -> csrf.disable())
        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) // 🔹 Mantener sesión activa
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/login", "/auth/login", "/css/**").permitAll() // Permitir acceso al login
            //.requestMatchers("/home").permitAll() // Requiere autenticación
            .anyRequest().permitAll());
        /*.formLogin(login -> login
            .loginPage("/login") // Página de login
            .defaultSuccessUrl("/home", true) // Redirigir a home después de login
            .permitAll()
        )
        .logout(logout -> logout
            .logoutUrl("/auth/logout")
            .logoutSuccessUrl("/login")
            .permitAll())*/

    return http.build();
    }   
}