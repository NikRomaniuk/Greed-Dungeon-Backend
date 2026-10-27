package io.github.nikromaniuk.greed_dungeon.floor.mappers;

import io.github.nikromaniuk.greed_dungeon.floor.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FloorPersistenceMapper
{
    Floor toDomain(FloorEntity entity);
    FloorEntity toEntity(Floor domain);
}
