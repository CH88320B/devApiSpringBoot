package com.webapipolizas.repository;

import com.webapipolizas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Optional<Usuario> findByLoginAndContrasena(String login, String contrasena);
}

