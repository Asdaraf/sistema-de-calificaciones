package com.edutecno.sistemacalificacionesfrontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class LoginController {

    

    @GetMapping("/login")
    public String login() {
        return "login"; // Solo mostrar la vista, sin redirecciones
    }

    /* 
    @PostMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            HttpServletResponse response,
            Model model) {
        try {
            String accessToken = userService.signin(username, password);
            session.setAttribute("accessToken", accessToken);

            Cookie cookie = new Cookie("accessToken", accessToken);
            cookie.setHttpOnly(true); // Asegura que la cookie no sea accesible desde JavaScript
            cookie.setSecure(true); // Asegura que la cookie solo se envíe a través de HTTPS
            cookie.setPath("/"); // Define el path para el cual la cookie es válida
            cookie.setMaxAge(60 * 60); // Define el tiempo de vida de la cookie en segundos (1 hora)

            // Agregar la cookie a la respuesta
            response.addCookie(cookie);
            return "redirect:/home";
        } catch (Exception e) {
            model.addAttribute("error", "Credenciales invalidas ");
            return "login";
        }
    }
        */
}
