package org.planet.service.impl;

import lombok.RequiredArgsConstructor;
import org.planet.exception.NotFoundException;
import org.planet.models.entity.Lord;
import org.planet.repository.LordRepository;
import org.planet.service.LordService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LordServiceImpl implements LordService {

    private final LordRepository lordRepository;

    @Override
    public Lord save(Lord lord) {
        return lordRepository.save(lord);
    }

    @Override
    public Lord getLordById(Long id) {
        return lordRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Wrong Lord id"));
    }

    @Override
    public Page<Lord> getLazyLords(Integer pageNo, Integer pageSize, String sortBy) {
        return lordRepository.findLazyLords(PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
    }

    @Override
    public Page<Lord> getLords(Integer pageNo, Integer pageSize, String sortBy) {
        return lordRepository.findAll(PageRequest.of(pageNo, pageSize, Sort.by(sortBy)));
    }

}
