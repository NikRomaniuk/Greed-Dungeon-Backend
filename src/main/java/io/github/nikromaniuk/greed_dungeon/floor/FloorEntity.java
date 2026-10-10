package io.github.nikromaniuk.greed_dungeon.floor;

import jakarta.persistence.*;

@Entity
@Table(name = "dungeon_floors")
public class FloorEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int id;

    private int depth;

    private String name;
}
