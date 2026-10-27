package io.github.nikromaniuk.greed_dungeon.floor.mappers;

import io.github.nikromaniuk.greed_dungeon.floor.*;
import io.github.nikromaniuk.greed_dungeon.floor.dto.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface FloorWebMapper
{
    @Mapping(target = "id", ignore = true)
    Floor toDomain(FloorCreateDto createDto);

    FloorResponseDto toResponse(Floor domain);
}
