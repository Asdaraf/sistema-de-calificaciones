package com.edutecno.sistemacalificacionesfrontend.service;

import com.edutecno.sistemacalificacionesfrontend.dto.AlumnoDTO;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class AlumnoService {

    private final RestTemplate restTemplate;
    // URL del endpoint del backend que lista los alumnos
    private final String backendAlumnosUrl = "http://localhost:3000/api/alumnos";

    
    public AlumnoService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<AlumnoDTO> getAllAlumnos(String token) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<List<AlumnoDTO>> response = restTemplate.exchange(
                backendAlumnosUrl,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<AlumnoDTO>>() {}
        );
        return response.getBody();
    }
}
