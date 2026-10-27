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
@Getter @Setter
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
    @JsonBackReference
    private List<HeroMementoEntity> mementos = new ArrayList<>();

    public List<HeroMementoEntity> getMementos()        { return Collections.unmodifiableList(mementos); }
    public void addMemento(HeroMementoEntity memento)   { memento.setHero(this); mementos.add(memento); }
    public void removeMemento(int index)                { mementos.remove(index); }
}
