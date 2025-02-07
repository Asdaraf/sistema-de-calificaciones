package com.edutecno.sistemacalificacionesapi.service;

import com.edutecno.sistemacalificacionesapi.entity.Role;
import com.edutecno.sistemacalificacionesapi.entity.User;
import com.edutecno.sistemacalificacionesapi.repository.UserRepository;
import com.edutecno.sistemacalificacionesapi.security.JwtTokenProvider;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtTokenProvider jwtTokenProvider) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    public String signup(String username, String email, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setRoles(Collections.singletonList(Role.ROLE_CLIENT));

        userRepository.save(user);
        return jwtTokenProvider.generateToken(username);
    }

    public String signin(String username, String password) {
        Optional<User> userOpt = userRepository.findByUsername(username);
        if (userOpt.isPresent() && passwordEncoder.matches(password, userOpt.get().getPassword())) {
            return jwtTokenProvider.generateToken(username);
        }
        throw new RuntimeException("Credenciales inválidas");
    }
}

