package org.planet.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlanetDTO {
    private Long id;
    private String name;
    private LordDTO lord;
}
