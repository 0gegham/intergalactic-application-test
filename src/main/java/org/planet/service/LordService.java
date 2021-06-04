package org.planet.service;

import org.planet.models.entity.Lord;
import org.springframework.data.domain.Page;

public interface LordService {
    Lord save(Lord lord);
    Lord getLordById(Long id);
    Page<Lord> getLazyLords(Integer pageNo, Integer pageSize, String sortBy);
    Page<Lord> getLords(Integer pageNo, Integer pageSize, String sortBy);
}
