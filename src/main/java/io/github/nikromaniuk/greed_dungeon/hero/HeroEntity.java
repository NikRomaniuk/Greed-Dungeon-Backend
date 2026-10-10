package io.github.nikromaniuk.greed_dungeon.hero;

import io.github.nikromaniuk.greed_dungeon.floor.FloorEntity;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoEntity;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "heroes")
public class HeroEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private int id;

    // Many heroes can be on the same dungeon floor
    @ManyToOne
    @JoinColumn(name = "floor_id")
    private FloorEntity floor;

    // One hero can have many mementos
    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HeroMementoEntity> mementos;
}
