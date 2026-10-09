package io.github.nikromaniuk.greed_dungeon.hero_memento;

import io.github.nikromaniuk.greed_dungeon.hero.HeroEntity;
import io.github.nikromaniuk.greed_dungeon.memento.MementoEntity;

// Junction Table between Heroes and Mementos for SPECIFIC M->M relationships
public class HeroMementoEntity
{
    private int id;

    private HeroEntity hero;

    private MementoEntity memento;

    private int level;
}
