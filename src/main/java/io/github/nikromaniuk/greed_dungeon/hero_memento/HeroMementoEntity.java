package io.github.nikromaniuk.greed_dungeon.hero_memento;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.nikromaniuk.greed_dungeon.hero.HeroEntity;
import io.github.nikromaniuk.greed_dungeon.memento.MementoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Junction Table between Heroes and Mementos for SPECIFIC M->M relationships
@Entity
@Table(name = "hero_mementos")
public class HeroMementoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @Getter @Setter
    private int id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    @JsonBackReference
    @Getter @Setter
    private HeroEntity hero;

    @ManyToOne
    @JoinColumn(name = "memento_id")
    @Getter @Setter
    private MementoEntity memento;

    @Getter @Setter
    private int mementoLevel;
}
