package org.planet.mapper;

public interface ModelMapper<E, D>{
    E dtoToEntity(D dto);
    D entityToDto(E entity);
}
