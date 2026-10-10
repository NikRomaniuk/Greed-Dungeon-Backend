package io.github.nikromaniuk.greed_dungeon.hero;

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

    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<HeroMementoEntity> mementos;
}
