package com.tuempresa.centrodeportivo.service.impl;

import com.tuempresa.centrodeportivo.dto.ClaseDTO;
import com.tuempresa.centrodeportivo.mapper.ClaseMapper;
import com.tuempresa.centrodeportivo.model.Clase;
import com.tuempresa.centrodeportivo.model.Usuario;
import com.tuempresa.centrodeportivo.repository.ClaseRepository;
import com.tuempresa.centrodeportivo.repository.UsuarioRepository;
import com.tuempresa.centrodeportivo.service.ClaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClaseServiceImpl implements ClaseService {

    private final ClaseRepository claseRepository;
    private final UsuarioRepository usuarioRepository;
    private final ClaseMapper claseMapper;

    @Override
    public List<ClaseDTO> listarTodas() {
        return claseRepository.findAll().stream()
                .map(claseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClaseDTO guardar(ClaseDTO claseDTO) {
        Clase clase = claseMapper.toEntity(claseDTO);
        return claseMapper.toDTO(claseRepository.save(clase));
    }

    @Override
    @Transactional // Importante para operaciones que tocan varias tablas
    public void anotarUsuarioAClase(Long claseId, Long usuarioId) {
        Clase clase = claseRepository.findById(claseId)
                .orElseThrow(() -> new RuntimeException("Clase no encontrada"));

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Lógica de negocio: Verificar cupo
        if (clase.getUsuarios().size() >= clase.getCupoMaximo()) {
            throw new RuntimeException("No hay más cupo disponible para esta clase");
        }

        clase.getUsuarios().add(usuario);
        claseRepository.save(clase);
    }
}