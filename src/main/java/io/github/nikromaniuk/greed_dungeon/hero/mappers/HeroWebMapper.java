package io.github.nikromaniuk.greed_dungeon.hero.mappers;

import io.github.nikromaniuk.greed_dungeon.floor.Floor;

import io.github.nikromaniuk.greed_dungeon.hero.Hero;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroCreateDto;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroResponseDto;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroVerbalDto;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMemento;
import io.github.nikromaniuk.greed_dungeon.hero_memento.mappers.HeroMementoWebMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = { HeroMementoWebMapper.class })
public interface HeroWebMapper
{
    @Mapping(target = "id", ignore = true)
    Hero toDomain(HeroCreateDto createDto, Floor floor, List<HeroMemento> mementos);

    @Mapping(target = "floorId", source = "floor.id")
    HeroResponseDto toResponse(Hero domain);

    @Mapping(target = "floor", source = "floor.name")
    HeroVerbalDto toVerbal(Hero domain);
}
