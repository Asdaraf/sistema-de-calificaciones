package com.edutecno.sistemacalificacionesfrontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {

        System.out.println("🔹 Se recibió solicitud a /home");

        Object token = session.getAttribute("token");
        //String token = (String) session.getAttribute("token");

        if (token == null) {
            System.out.println("❌ No hay token en la sesión. Redirigiendo a login.");
            return "redirect:/login"; // 🔹 Si no hay token, redirigir a login
        }

        System.out.println("✅ Token encontrado en sesión: " + token);
        model.addAttribute("token", token);
        return "home"; // Mostrar home.html
    }
}
