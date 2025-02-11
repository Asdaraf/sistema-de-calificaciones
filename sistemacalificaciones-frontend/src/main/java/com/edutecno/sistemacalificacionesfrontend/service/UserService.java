package com.edutecno.sistemacalificacionesfrontend.service;

import com.edutecno.sistemacalificacionesfrontend.dto.UserDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

@Service
public class UserService {

    private final RestTemplate restTemplate;
    // URL del endpoint de registro en el backend
    private final String backendSignupUrl = "http://localhost:3000/api/auth/signup";
    // URL del endpoint de login en el backend
    private final String backendSigninUrl = "http://localhost:3000/api/auth/signin";

    
    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Registra un usuario enviando un UserDTO al backend.
     * Se espera que el backend devuelva un objeto JSON con el token (por ejemplo: {"token": "..."}).
     */
    public Map<String, String> signup(UserDTO userDTO) {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);
         HttpEntity<UserDTO> entity = new HttpEntity<>(userDTO, headers);

         ResponseEntity<Map<String, String>> response = restTemplate.exchange(
               backendSignupUrl,
               HttpMethod.POST,
               entity,
               new ParameterizedTypeReference<Map<String, String>>() {}
         );
         return response.getBody();
    }

    /**
     * Inicia sesión enviando las credenciales (username y password) al backend.
     * Se espera que el backend devuelva un objeto JSON con el token.
     */
    public Map<String, String> signin(String username, String password) {
         HttpHeaders headers = new HttpHeaders();
         headers.setContentType(MediaType.APPLICATION_JSON);

         Map<String, String> credentials = Map.of("username", username, "password", password);
         HttpEntity<Map<String, String>> entity = new HttpEntity<>(credentials, headers);

         ResponseEntity<Map<String, String>> response = restTemplate.exchange(
               backendSigninUrl,
               HttpMethod.POST,
               entity,
               new ParameterizedTypeReference<Map<String, String>>() {}
         );
         return response.getBody();
    }
}
