package com.edutecno.sistemacalificacionesfrontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final RestTemplate restTemplate;
    private final String backendUrl = "http://localhost:3000/api/auth/signin"; // URL del backend

    public AuthController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);

            Map<String, String> request = Map.of("username", username, "password", password);
            HttpEntity<Map<String, String>> entity = new HttpEntity<>(request, headers);

            System.out.println("📤 Enviando solicitud al backend con: " + request);

            ResponseEntity<Map> response = restTemplate.exchange(backendUrl, HttpMethod.POST, entity, Map.class);

            System.out.println("🔹 Respuesta del backend: " + response.getStatusCode());
            System.out.println("🔹 Cuerpo: " + response.getBody());

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                String token = (String) response.getBody().get("token");

                if (token != null) {
                    session.setAttribute("token", token); // 🔹 Guardar token en sesión
                    System.out.println("✅ Token guardado en sesión, redirigiendo a /home");
                    return "redirect:/home"; // Redirigir a home
                }
            }
            model.addAttribute("error", true);
            return "login";
        } catch (Exception e) {
            System.err.println("❌ Error en el login: " + e.getMessage());
            model.addAttribute("error", true);
            return "login";
        }
    }
}

