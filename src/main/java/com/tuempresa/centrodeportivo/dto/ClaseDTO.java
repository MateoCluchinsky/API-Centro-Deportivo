package com.tuempresa.centrodeportivo.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ClaseDTO {
    private Long id;

    @NotBlank(message = "La clase debe tener un nombre")
    private String nombre;

    @NotNull(message = "El horario es obligatorio")
    private LocalDateTime horario;

    @Min(value = 1, message = "El cupo mínimo es 1")
    private Integer cupoMaximo;
}