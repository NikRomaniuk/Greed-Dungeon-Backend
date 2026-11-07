package io.github.nikromaniuk.greed_dungeon.memento;

import lombok.Getter;

@Getter
public class Memento
{
    // --- Fields ---

    private Long id;
    private String name;

    // --- Constructors ---

    public Memento(Long id, String name)
    {
        this.id = id;
        this.name = name;
    }
}
