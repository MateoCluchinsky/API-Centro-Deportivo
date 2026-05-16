package com.tuempresa.centrodeportivo.controller;

import com.tuempresa.centrodeportivo.dto.UsuarioDTO;
import com.tuempresa.centrodeportivo.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // POST - Crear
    @PostMapping
    public ResponseEntity<UsuarioDTO> crear(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuarioService.guardar(usuarioDTO), HttpStatus.CREATED);
    }

    // GET - Obtener todos o filtrar por rol (Uso de Query Params)
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> obtenerTodos(@RequestParam(required = false) String rol) {
        return ResponseEntity.ok(usuarioService.obtenerTodos(rol));
    }

    // GET - Obtener por ID (Uso de Path Variables)
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(usuarioService.obtenerPorId(id));
    }

    // PUT - Actualizar (Path Variable + Body validado)
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Long id, @Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.ok(usuarioService.actualizar(id, usuarioDTO));
    }

    // DELETE - Eliminar (Path Variable)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        usuarioService.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}