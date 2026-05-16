package com.tuempresa.centrodeportivo.service;

import com.tuempresa.centrodeportivo.dto.UsuarioDTO;
import com.tuempresa.centrodeportivo.mapper.UsuarioMapper;
import com.tuempresa.centrodeportivo.model.Usuario;
import com.tuempresa.centrodeportivo.repository.UsuarioRepository;
import com.tuempresa.centrodeportivo.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @BeforeEach
    void setUp() {
        // Inicializa los objetos simulados (Mocks) antes de cada prueba
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void obtenerPorId_CuandoUsuarioExiste_RetornaUsuarioDTO() {
        // 1. Preparación (Arrange)
        Long idPrueba = 1L;

        Usuario usuarioSimulado = new Usuario();
        usuarioSimulado.setId(idPrueba);
        usuarioSimulado.setUsername("atleta_test");

        UsuarioDTO dtoSimulado = new UsuarioDTO();
        dtoSimulado.setId(idPrueba);
        dtoSimulado.setUsername("atleta_test");

        // Le dice a Mockito qué hacer cuando el servicio llame al repositorio o al
        // mapper
        when(usuarioRepository.findById(idPrueba)).thenReturn(Optional.of(usuarioSimulado));
        when(usuarioMapper.toDTO(usuarioSimulado)).thenReturn(dtoSimulado);

        // 2. Ejecución (Act)
        UsuarioDTO resultado = usuarioService.obtenerPorId(idPrueba);

        // 3. Verificación (Assert)
        assertNotNull(resultado, "El resultado no debería ser nulo");
        assertEquals("atleta_test", resultado.getUsername(), "El nombre de usuario no coincide");

        // Verifica que el repositorio realmente haya sido consultado 1 vez
        verify(usuarioRepository, times(1)).findById(idPrueba);
    }
}