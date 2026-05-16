package com.tuempresa.centrodeportivo.service.impl; // Creá la subcarpeta 'impl'

import com.tuempresa.centrodeportivo.dto.UsuarioDTO;
import com.tuempresa.centrodeportivo.mapper.UsuarioMapper;
import com.tuempresa.centrodeportivo.model.Usuario;
import com.tuempresa.centrodeportivo.repository.UsuarioRepository;
import com.tuempresa.centrodeportivo.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor // Esto inyecta los componentes automáticamente
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDTO guardar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);

        // TODO: Implementar encriptación de contraseñas (ej: BCrypt) en el futuro.
        // Se asigna una por defecto temporalmente para cumplir con las reglas de la BD.
        usuario.setPassword("123456");

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    @Override
    public List<UsuarioDTO> obtenerTodos(String rol) {
        List<Usuario> usuarios;
        // Lógica para el Query Param: Si me pasan un rol, filtro. Si no, devuelvo
        // todos.
        if (rol != null && !rol.isEmpty()) {
            usuarios = usuarioRepository.findByRol(rol);
        } else {
            usuarios = usuarioRepository.findAll();
        }
        return usuarios.stream()
                .map(usuarioMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO obtenerPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));
        return usuarioMapper.toDTO(usuario);
    }

    @Override
    public UsuarioDTO actualizar(Long id, UsuarioDTO usuarioDTO) {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado con ID: " + id));

        usuarioExistente.setUsername(usuarioDTO.getUsername());
        usuarioExistente.setEmail(usuarioDTO.getEmail());
        usuarioExistente.setRol(usuarioDTO.getRol());

        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
        return usuarioMapper.toDTO(usuarioActualizado);
    }

    @Override
    public void eliminar(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new RuntimeException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }
}