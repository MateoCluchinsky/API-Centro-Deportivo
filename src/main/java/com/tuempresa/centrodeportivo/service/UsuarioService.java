package com.tuempresa.centrodeportivo.service;

import com.tuempresa.centrodeportivo.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {
    List<UsuarioDTO> listarTodos();

    UsuarioDTO guardar(UsuarioDTO usuarioDTO);

    UsuarioDTO obtenerPorId(Long id);

    void eliminar(Long id);
}