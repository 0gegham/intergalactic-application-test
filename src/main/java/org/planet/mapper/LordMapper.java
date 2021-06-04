package org.planet.mapper;

import org.mapstruct.Mapper;
import org.planet.models.dto.LordDTO;
import org.planet.models.entity.Lord;

@Mapper(componentModel = "spring")
public interface LordMapper extends ModelMapper<Lord, LordDTO> {
}
