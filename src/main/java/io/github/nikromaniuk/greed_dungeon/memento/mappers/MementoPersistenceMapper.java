package io.github.nikromaniuk.greed_dungeon.memento.mappers;

import io.github.nikromaniuk.greed_dungeon.memento.Memento;
import io.github.nikromaniuk.greed_dungeon.memento.MementoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MementoPersistenceMapper
{
    Memento toDomain(MementoEntity entity);
    MementoEntity toEntity(Memento domain);
}
