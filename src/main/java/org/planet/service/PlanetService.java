package org.planet.service;

import org.planet.models.entity.Planet;

public interface PlanetService {
    Planet save(Planet planet);
    Planet getPlanetById(Long id);
    void destroyById(Long id);
    Planet setNewLord(Long planetId, Long lordId);
}
