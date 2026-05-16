package com.tuempresa.centrodeportivo.service;

import com.tuempresa.centrodeportivo.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    UsuarioDTO guardar(UsuarioDTO usuarioDTO);

    // Nuevos métodos para el CRUD
    List<UsuarioDTO> obtenerTodos(String rol);

    UsuarioDTO obtenerPorId(Long id);

    UsuarioDTO actualizar(Long id, UsuarioDTO usuarioDTO);

    void eliminar(Long id);
}