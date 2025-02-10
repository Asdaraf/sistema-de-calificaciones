package com.edutecno.sistemacalificacionesfrontend.controller;

import com.edutecno.sistemacalificacionesfrontend.dto.AlumnoDTO;
import com.edutecno.sistemacalificacionesfrontend.service.AlumnoService;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AlumnoController {

    private final AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/estudiantes")
    public String listarEstudiantes(HttpSession session, Model model) {

        String token = (String) session.getAttribute("token");

        List<AlumnoDTO> alumnos = alumnoService.getAllAlumnos(token);
        model.addAttribute("alumnos", alumnos);
        return "alumnos"; // Vista que muestra el listado de estudiantes
    }
}
