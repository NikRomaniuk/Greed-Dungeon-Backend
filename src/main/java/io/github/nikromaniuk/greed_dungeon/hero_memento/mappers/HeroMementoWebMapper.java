package io.github.nikromaniuk.greed_dungeon.hero_memento.mappers;

import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMemento;
import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoCreateDto;
import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoResponseDto;
import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoVerbalDto;
import io.github.nikromaniuk.greed_dungeon.memento.Memento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface HeroMementoWebMapper
{
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "hero", ignore = true)
    HeroMemento toDomain(HeroMementoCreateDto createDto, Memento memento);

    HeroMementoResponseDto toResponse(HeroMemento domain);

    @Mapping(source = "memento.name", target = "name")
    @Mapping(source = "level", target = "level")
    HeroMementoVerbalDto toVerbal(HeroMemento domain);
}
