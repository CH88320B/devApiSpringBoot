package com.webapipolizas.controller;

import com.webapipolizas.dto.LoginRequest;
import com.webapipolizas.model.Usuario;
import com.webapipolizas.repository.UsuarioRepository;
import com.webapipolizas.security.JwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JwUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request) {
        return usuarioRepository
                .findByLoginAndContrasena(request.getLogin(), request.getContrasena())
                .map(usuario -> ResponseEntity.ok(jwtUtil.generateToken(usuario.getLogin())))
                .orElse(ResponseEntity.status(401).body("Credenciales inválidas"));
    }
}
