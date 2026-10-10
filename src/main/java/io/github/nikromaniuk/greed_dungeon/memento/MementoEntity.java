package io.github.nikromaniuk.greed_dungeon.memento;

import jakarta.persistence.*;

@Entity
@Table(name = "mementos")
public class MementoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int id;

    private String name;
}
