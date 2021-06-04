package org.planet.service.impl;

import lombok.RequiredArgsConstructor;
import org.planet.exception.IntergalacticException;
import org.planet.exception.NotFoundException;
import org.planet.models.entity.Planet;
import org.planet.repository.LordRepository;
import org.planet.repository.PlanetRepository;
import org.planet.service.PlanetService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService {

    private final PlanetRepository planetRepository;
    private final LordRepository lordRepository;

    @Override
    public Planet save(Planet planet) {
        return planetRepository.save(planet);
    }

    @Override
    public Planet getPlanetById(Long id) {
        return planetRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("There is not such planet"));
    }

    @Override
    public void destroyById(Long id) {
        if (!planetRepository.existsById(id)) {
            throw new NotFoundException("There is no such planet");
        }

        planetRepository.deleteById(id);
    }

    @Override
    public Planet setNewLord(Long planetId, Long lordId) {
        Planet planet = getPlanetById(planetId);

        if (!planetRepository.hasLord(planetId, lordId)) {
            planet.setLord(lordRepository.findById(lordId)
                    .orElseThrow(() -> new NotFoundException("Wrong Lord id")));
            return planetRepository.save(planet);
        }

        throw new IntergalacticException("There is a lord. This Planet Ain't Big Enough For Both Of Us");
    }
}
