package io.github.nikromaniuk.greed_dungeon.hero_memento.mappers;

import io.github.nikromaniuk.greed_dungeon.hero.mappers.HeroPersistenceMapper;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMemento;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoEntity;
import io.github.nikromaniuk.greed_dungeon.memento.mappers.MementoPersistenceMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(
        componentModel = "spring",
        uses = { HeroPersistenceMapper.class, MementoPersistenceMapper.class })
public interface HeroMementoPersistenceMapper
{
    @Mapping(target = "hero", ignore = true)
    HeroMemento toDomain(HeroMementoEntity entity);

    @Mapping(target = "hero", ignore = true)
    HeroMementoEntity toEntity(HeroMemento domain);
}
