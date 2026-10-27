package io.github.nikromaniuk.greed_dungeon.hero.mappers;

import io.github.nikromaniuk.greed_dungeon.floor.mappers.FloorPersistenceMapper;
import io.github.nikromaniuk.greed_dungeon.hero.*;
import io.github.nikromaniuk.greed_dungeon.hero_memento.mappers.HeroMementoPersistenceMapper;
import org.mapstruct.Mapper;

@Mapper(
        componentModel = "spring",
        uses = { FloorPersistenceMapper.class, HeroMementoPersistenceMapper.class })
public interface HeroPersistenceMapper
{
    Hero toDomain(HeroEntity entity);
    HeroEntity toEntity(Hero domain);
}
