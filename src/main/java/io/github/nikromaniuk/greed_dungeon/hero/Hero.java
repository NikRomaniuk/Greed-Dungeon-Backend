package io.github.nikromaniuk.greed_dungeon.hero;

import io.github.nikromaniuk.greed_dungeon.floor.FloorEntity;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoEntity;

import java.util.ArrayList;
import java.util.List;

public class Hero
{
    // --- FIELDS ---

    private int id;
    private FloorEntity floor;
    private List<HeroMementoEntity> mementos;

    public Hero(int id, FloorEntity floor, List<HeroMementoEntity> mementos)
    {
        this.id = id;
        this.floor = floor;
        this.mementos = mementos;
    }
}
