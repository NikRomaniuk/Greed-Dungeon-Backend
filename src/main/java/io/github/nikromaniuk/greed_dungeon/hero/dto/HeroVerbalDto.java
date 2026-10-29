package io.github.nikromaniuk.greed_dungeon.hero.dto;

import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoVerbalDto;

import java.util.List;

public record HeroVerbalDto(
        String floorName,
        List<HeroMementoVerbalDto> mementos)
{

}
