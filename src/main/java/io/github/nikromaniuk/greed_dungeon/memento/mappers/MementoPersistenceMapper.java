package io.github.nikromaniuk.greed_dungeon.memento.mappers;

import io.github.nikromaniuk.greed_dungeon.memento.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MementoPersistenceMapper
{
    Memento toDomain(MementoEntity entity);
    MementoEntity toEntity(Memento domain);
}
