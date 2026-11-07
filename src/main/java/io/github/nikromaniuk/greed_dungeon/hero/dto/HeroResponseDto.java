package io.github.nikromaniuk.greed_dungeon.hero.dto;

import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoResponseDto;

import java.util.List;

public record HeroResponseDto(
        Long id,
        Long floorId,
        List<HeroMementoResponseDto> mementos)
{

}
