package io.github.nikromaniuk.greed_dungeon.hero_memento;

import io.github.nikromaniuk.greed_dungeon.hero.Hero;
import io.github.nikromaniuk.greed_dungeon.memento.Memento;

public class HeroMemento
{
    // --- FIELDS ---

    private int id;
    private Hero hero;
    private Memento memento;
    private int level;

    // --- CONSTRUCTORS ---

    public HeroMemento(int id, Hero hero, Memento memento, int level)
    {
        this.id = id;
        this.hero = hero;
        this.memento = memento;
        this.level = level;
    }
}
