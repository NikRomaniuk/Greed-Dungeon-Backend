package io.github.nikromaniuk.greed_dungeon.hero.dto;

import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoCreateDto;

import java.util.List;

public record HeroCreateDto(
        int floorId,
        List<HeroMementoCreateDto> mementos)
{

}
