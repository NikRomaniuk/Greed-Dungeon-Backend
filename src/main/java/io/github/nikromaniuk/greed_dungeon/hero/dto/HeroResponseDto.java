package io.github.nikromaniuk.greed_dungeon.hero.dto;

import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoResponseDto;

import java.util.List;

public record HeroResponseDto(
        int id,
        int floorId,
        List<HeroMementoResponseDto> mementos)
{

}
