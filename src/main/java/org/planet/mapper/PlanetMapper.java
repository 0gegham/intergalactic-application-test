package org.planet.mapper;

import org.mapstruct.Mapper;
import org.planet.models.dto.PlanetDTO;
import org.planet.models.entity.Planet;

@Mapper(componentModel = "spring")
public interface PlanetMapper extends ModelMapper<Planet, PlanetDTO> {
}
