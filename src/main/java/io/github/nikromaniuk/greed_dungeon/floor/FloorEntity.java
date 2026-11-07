package io.github.nikromaniuk.greed_dungeon.floor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "dungeon_floors")
@Getter @Setter
public class FloorEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment
    private Long id;

    @Column(name = "depth", columnDefinition = "SMALLINT UNSIGNED")
    private int depth;

    @Column(name = "name")
    private String name;
}
