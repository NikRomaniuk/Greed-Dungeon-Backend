package io.github.nikromaniuk.greed_dungeon.hero;

import io.github.nikromaniuk.greed_dungeon.floor.Floor;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMemento;
import lombok.Getter;

import java.util.List;

@Getter
public class Hero
{
    // --- FIELDS ---

    private int id;
    private Floor floor;
    private List<HeroMemento> mementos;

    // --- CONSTRUCTORS ---

    public Hero(int id, Floor floor, List<HeroMemento> mementos)
    {
        this.id = id;
        this.floor = floor;
        this.mementos = mementos;
    }
}
