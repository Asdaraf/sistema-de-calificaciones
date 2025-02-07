package com.edutecno.sistemacalificacionesapi.controller;

import com.edutecno.sistemacalificacionesapi.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Map<String, String>> signup(@RequestBody Map<String, String> request) {
        String token = userService.signup(request.get("username"), request.get("email"), request.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/signin")
    public ResponseEntity<Map<String, String>> signin(@RequestBody Map<String, String> request) {
        String token = userService.signin(request.get("username"), request.get("password"));
        return ResponseEntity.ok(Map.of("token", token));
    }
}

