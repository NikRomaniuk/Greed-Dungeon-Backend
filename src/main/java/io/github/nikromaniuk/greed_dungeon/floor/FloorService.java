package io.github.nikromaniuk.greed_dungeon.floor;

import io.github.nikromaniuk.greed_dungeon.floor.dto.*;
import io.github.nikromaniuk.greed_dungeon.floor.mappers.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService
{
    private final FloorRepository floorRepository;
    private final FloorWebMapper floorWebMapper;
    private final FloorPersistenceMapper floorPersistenceMapper;

    public FloorService(
            FloorRepository floorRepository,
            FloorWebMapper floorWebMapper,
            FloorPersistenceMapper floorPersistenceMapper)
    {
        this.floorRepository = floorRepository;
        this.floorWebMapper = floorWebMapper;
        this.floorPersistenceMapper = floorPersistenceMapper;
    }

    public List<FloorResponseDto> getAllFloors()
    {
        List<FloorEntity> entities = floorRepository.findAll();

        List<Floor> domains = entities.stream()
                .map(floorPersistenceMapper::toDomain)
                .toList();

        return domains.stream()
                .map(floorWebMapper::toResponse)
                .toList();
    }

    public void createFloor(FloorCreateDto dto)
    {
        if (dto == null) { return; }

        // DTO -> Domain
        Floor domain = floorWebMapper.toDomain(dto);

        // Domain -> Entity
        FloorEntity entity = floorPersistenceMapper.toEntity(domain);

        // Save Entity
        floorRepository.save(entity);
    }
}
