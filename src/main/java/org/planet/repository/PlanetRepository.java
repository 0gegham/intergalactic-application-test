package org.planet.repository;

import org.planet.models.entity.Planet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends PagingAndSortingRepository<Planet, Long> {
    @Query(
            value = "select pl from planets pl where pl.id = :planetId and pl.lord_id = :lordId",
            nativeQuery = true
    )
    boolean hasLord(@Param("planetId") Long planetId, @Param("lordId") Long lordId);
}
