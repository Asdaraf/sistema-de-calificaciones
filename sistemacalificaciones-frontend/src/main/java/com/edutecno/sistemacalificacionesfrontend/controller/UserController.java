package com.edutecno.sistemacalificacionesfrontend.controller;

import com.edutecno.sistemacalificacionesfrontend.dto.UserDTO;
import com.edutecno.sistemacalificacionesfrontend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Endpoint para registrar un usuario (signup)
    @PostMapping("/signup")
    public String signup(@ModelAttribute UserDTO userDTO, HttpSession session, Model model) {
        try {
            Map<String, String> response = userService.signup(userDTO);
            String token = response.get("token");
            if (token != null) {
                session.setAttribute("token", token);
                return "redirect:/home";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error en el registro: " + e.getMessage());
        }
        return "signup"; // Una vista para mostrar el formulario de registro
    }

    // Endpoint para iniciar sesión (signin)
    @PostMapping("/signin")
    public String signin(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        try {
            Map<String, String> response = userService.signin(username, password);
            String token = response.get("token");
            if (token != null) {
                session.setAttribute("token", token);
                return "redirect:/home";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Error en el inicio de sesión: " + e.getMessage());
        }
        return "login"; // Vista de login en caso de error
    }
}
