package com.tuempresa.centrodeportivo.mapper;

import com.tuempresa.centrodeportivo.dto.UsuarioDTO;
import com.tuempresa.centrodeportivo.model.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    UsuarioDTO toDTO(Usuario usuario);

    // Le decimos a MapStruct que ignore los campos que el DTO no tiene
    @Mapping(target = "clases", ignore = true)
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "plan", ignore = true)
    Usuario toEntity(UsuarioDTO usuarioDTO);
}