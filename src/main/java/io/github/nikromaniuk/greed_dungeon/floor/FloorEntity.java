package io.github.nikromaniuk.greed_dungeon.floor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dungeon_floors")
public class FloorEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @Getter @Setter
    private int id;

    @Getter @Setter
    private int depth;

    @Getter @Setter
    private String name;
}
