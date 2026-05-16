package com.tuempresa.centrodeportivo.controller;

import com.tuempresa.centrodeportivo.dto.ClaseDTO;
import com.tuempresa.centrodeportivo.service.ClaseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clases")
@RequiredArgsConstructor
public class ClaseController {

    private final ClaseService claseService;

    @GetMapping
    public ResponseEntity<List<ClaseDTO>> listarTodas() {
        return ResponseEntity.ok(claseService.listarTodas());
    }

    @PostMapping
    public ResponseEntity<ClaseDTO> crear(@Valid @RequestBody ClaseDTO claseDTO) {
        return new ResponseEntity<>(claseService.guardar(claseDTO), HttpStatus.CREATED);
    }

    // Este es el endpoint de la relación compleja (Many-To-Many)
    @PostMapping("/{claseId}/usuarios/{usuarioId}")
    public ResponseEntity<String> anotarUsuario(@PathVariable Long claseId, @PathVariable Long usuarioId) {
        claseService.anotarUsuarioAClase(claseId, usuarioId);
        return ResponseEntity.ok("Usuario anotado a la clase con éxito. ¡A entrenar!");
    }
}