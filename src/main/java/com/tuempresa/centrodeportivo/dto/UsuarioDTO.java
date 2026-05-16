package com.tuempresa.centrodeportivo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UsuarioDTO {
    
    private Long id;

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String username;

    @NotBlank(message = "El email es obligatorio")
    @Email(message = "Debe tener un formato de email válido")
    private String email;

    @NotBlank(message = "El rol es obligatorio")
    private String rol;
}