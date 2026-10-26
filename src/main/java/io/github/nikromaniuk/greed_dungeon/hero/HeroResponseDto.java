package io.github.nikromaniuk.greed_dungeon.hero;

import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoEntity;

import java.util.List;

public record HeroResponseDto(
        int id,
        int floorId,
        List<HeroMementoResponseDto> mementos)
{
    public record HeroMementoResponseDto(
            int id,
            int level
    ) {
        public static HeroMementoResponseDto fromEntity(HeroMementoEntity entity)
        {
            return new HeroMementoResponseDto(entity.getId(), entity.getLevel());
        }
    }

    public static HeroResponseDto fromEntity(HeroEntity entity)
    {
        if (entity == null) {return null;}

        List<HeroMementoResponseDto> mementos = entity.getMementos().stream()
                .map(HeroMementoResponseDto::fromEntity)
                .toList();

        int floorId = entity.getFloor() != null ? entity.getFloor().getId() : 0;

        return new HeroResponseDto(
                entity.getId(),
                floorId,
                mementos
        );
    }
}
