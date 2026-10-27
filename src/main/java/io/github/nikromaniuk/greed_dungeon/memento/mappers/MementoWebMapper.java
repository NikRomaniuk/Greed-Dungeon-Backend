package io.github.nikromaniuk.greed_dungeon.memento.mappers;

import io.github.nikromaniuk.greed_dungeon.memento.Memento;
import io.github.nikromaniuk.greed_dungeon.memento.dto.MementoCreateDto;
import io.github.nikromaniuk.greed_dungeon.memento.dto.MementoResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MementoWebMapper
{
    @Mapping(target = "id", ignore = true)
    Memento toDomain(MementoCreateDto createDto);

    MementoResponseDto toResponse(Memento domain);
}
