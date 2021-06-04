package org.planet.repository;

import org.planet.models.entity.Lord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LordRepository extends PagingAndSortingRepository<Lord, Long> {
    @Query(
            value = "select * from lords where lords.id not in (select planets.lord_id from planets where planets.lord_id is not null)",
            nativeQuery = true
    )
    Page<Lord> findLazyLords(Pageable var1);
}
