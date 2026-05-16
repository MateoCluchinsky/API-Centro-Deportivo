package com.tuempresa.centrodeportivo.repository;

import com.tuempresa.centrodeportivo.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Método necesario para la seguridad
    Optional<Usuario> findByUsername(String username);

    // Query personalizada para cumplir con la rúbrica
    List<Usuario> findByRol(String rol);

}