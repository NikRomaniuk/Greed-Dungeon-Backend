package io.github.nikromaniuk.greed_dungeon.hero;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.github.nikromaniuk.greed_dungeon.floor.FloorEntity;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Entity
@Table(name = "heroes")
public class HeroEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    @Getter @Setter
    private int id;

    // Many heroes can be on the same dungeon floor
    @ManyToOne
    @JoinColumn(name = "floor_id")
    @Getter @Setter
    private FloorEntity floor;

    // One hero can have many mementos
    @OneToMany(mappedBy = "hero", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    @Setter
    private List<HeroMementoEntity> mementos = new ArrayList<>();

    public List<HeroMementoEntity> getMementos()        { return new ArrayList<>(mementos); }
    public void addMemento(HeroMementoEntity memento)   { mementos.add(memento); }
    public void removeMemento(int index)                { mementos.remove(index); }
}
