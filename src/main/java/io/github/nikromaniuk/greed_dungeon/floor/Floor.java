package io.github.nikromaniuk.greed_dungeon.floor;

import lombok.Getter;

@Getter
public class Floor
{
    // --- FIELDS ---

    private Long id;
    private int depth;
    private String name;

    // --- CONSTRUCTORS ---

    public Floor(Long id, int depth, String name)
    {
        this.id = id;
        this.depth = depth;
        this.name = name;
    }
}
