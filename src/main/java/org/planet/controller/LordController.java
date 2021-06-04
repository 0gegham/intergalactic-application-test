package org.planet.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.planet.mapper.LordMapper;
import org.planet.models.dto.LordDTO;
import org.planet.models.entity.Lord;
import org.planet.service.LordService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/lord")
@RequiredArgsConstructor
@Tag(name = "Lord Controller", description = "Interact with Lords")
public class LordController {
    private final LordService lordService;
    private final LordMapper lordMapper;

    @PostMapping(path = "/new")
    public LordDTO addNewLord(@RequestBody LordDTO lord) {
        Lord lordEntity = lordMapper.dtoToEntity(lord);
        return lordMapper.entityToDto(lordService.save(lordEntity));
    }

    @GetMapping(path = "/lazy")
    public Page<LordDTO> lazyLords(@RequestParam(defaultValue = "10") Integer size) {
        return lordService.getLazyLords(0, size, "id")
                .map(lordMapper::entityToDto);
    }

    @GetMapping(path = "/top")
    public Page<LordDTO> topLords(@RequestParam(defaultValue = "10") Integer size) {
        return lordService.getLords(0, size, "age")
                .map(lordMapper::entityToDto);
    }
}
