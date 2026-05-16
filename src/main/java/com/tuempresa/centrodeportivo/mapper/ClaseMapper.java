package com.tuempresa.centrodeportivo.mapper;

import com.tuempresa.centrodeportivo.dto.ClaseDTO;
import com.tuempresa.centrodeportivo.model.Clase;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClaseMapper {

    ClaseDTO toDTO(Clase clase);

    @Mapping(target = "usuarios", ignore = true)
    Clase toEntity(ClaseDTO claseDTO);
}