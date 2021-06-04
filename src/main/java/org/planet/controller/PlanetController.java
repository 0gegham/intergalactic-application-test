package org.planet.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.planet.mapper.PlanetMapper;
import org.planet.models.dto.PlanetDTO;
import org.planet.models.entity.Planet;
import org.planet.service.PlanetService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/planet")
@RequiredArgsConstructor
@Tag(name = "Planet Controller", description = "Interact with planets")
public class PlanetController {
    private final PlanetService planetService;
    private final PlanetMapper planetMapper;

    @PostMapping(path = "/new")
    public PlanetDTO addNewPlanet(@RequestBody PlanetDTO planet) {
        Planet planetEntity = planetMapper.dtoToEntity(planet);
        return planetMapper.entityToDto(planetService.save(planetEntity));
    }

    @PatchMapping(path = "/set_lord")
    public PlanetDTO setNewLord(@RequestParam(value = "planet_id") Long planetId,
                                @RequestParam(value = "lord_id") Long lordId) {
        return planetMapper.entityToDto(planetService.setNewLord(planetId, lordId));
    }

    @DeleteMapping(path = "/destroy")
    public void destroy(@RequestParam(value = "id") Long id) {
        planetService.destroyById(id);
    }

}
