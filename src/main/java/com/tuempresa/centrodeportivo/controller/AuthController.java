package com.tuempresa.centrodeportivo.controller;

import com.tuempresa.centrodeportivo.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService,
            JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credenciales) {
        try {
            // Intenta autenticar con los datos que manda Postman
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(credenciales.get("username"),
                            credenciales.get("password")));
        } catch (Exception e) {
            return ResponseEntity.status(401).body(Map.of("error", "Credenciales incorrectas"));
        }

        // Si pasó, busca el usuario y le fabrica el token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(credenciales.get("username"));
        final String jwt = jwtUtil.generateToken(userDetails.getUsername());

        // Devuelve el token en formato JSON
        return ResponseEntity.ok(Map.of("token", jwt));
    }
}