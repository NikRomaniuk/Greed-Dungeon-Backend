package io.github.nikromaniuk.greed_dungeon.memento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mementos")
public class MementoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @Getter @Setter
    private int id;

    @Getter @Setter
    private String name;
}
