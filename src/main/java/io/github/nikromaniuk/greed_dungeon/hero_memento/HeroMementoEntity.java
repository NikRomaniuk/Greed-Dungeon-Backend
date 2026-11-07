package io.github.nikromaniuk.greed_dungeon.hero_memento;

import io.github.nikromaniuk.greed_dungeon.hero.HeroEntity;
import io.github.nikromaniuk.greed_dungeon.memento.MementoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// Junction Table between Heroes and Mementos for SPECIFIC M->M relationships
@Entity
@Table(name = "hero_mementos")
@Getter @Setter
public class HeroMementoEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hero_id")
    private HeroEntity hero;

    @ManyToOne
    @JoinColumn(name = "memento_id")
    private MementoEntity memento;

    @Column(name = "mementoLevel", columnDefinition = "SMALLINT UNSIGNED")
    private int mementoLevel;
}
