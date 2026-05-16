package com.tuempresa.centrodeportivo.service;

import com.tuempresa.centrodeportivo.dto.ClaseDTO;
import java.util.List;

public interface ClaseService {
    List<ClaseDTO> listarTodas();

    ClaseDTO guardar(ClaseDTO claseDTO);

    void anotarUsuarioAClase(Long claseId, Long usuarioId); // Lógica compleja
}