package io.github.nikromaniuk.greed_dungeon.memento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "mementos")
@Getter @Setter
public class MementoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(name = "name")
    private String name;
}
