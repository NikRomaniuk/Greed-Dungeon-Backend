package io.github.nikromaniuk.greed_dungeon.hero_memento;

import io.github.nikromaniuk.greed_dungeon.hero.HeroEntity;
import io.github.nikromaniuk.greed_dungeon.memento.MementoEntity;
import jakarta.persistence.*;

// Junction Table between Heroes and Mementos for SPECIFIC M->M relationships
@Entity
@Table(name = "hero_mementos")
public class HeroMementoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private HeroEntity hero;

    @ManyToOne
    @JoinColumn(name = "memento_id")
    private MementoEntity memento;

    private int level;
}
