package io.github.nikromaniuk.greed_dungeon.hero;

import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoDto;

import java.util.List;

public record CreateHeroDto(int floorId, List<HeroMementoDto> mementos)
{

}
