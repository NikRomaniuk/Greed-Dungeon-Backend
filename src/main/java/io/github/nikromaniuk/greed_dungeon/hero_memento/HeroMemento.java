package io.github.nikromaniuk.greed_dungeon.hero_memento;

import io.github.nikromaniuk.greed_dungeon.hero.Hero;
import io.github.nikromaniuk.greed_dungeon.memento.Memento;
import lombok.Getter;

@Getter
public class HeroMemento
{
    // --- Fields ---

    private int id;
    private Hero hero;
    private Memento memento;
    private int mementoLevel;

    // --- Constructors ---

    public HeroMemento(int id, Hero hero, Memento memento, int mementoLevel)
    {
        this.id = id;
        this.hero = hero;
        this.memento = memento;
        this.mementoLevel = mementoLevel;
    }
}
