package io.github.nikromaniuk.greed_dungeon.memento;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MementoRepository extends JpaRepository<MementoEntity, Integer>
{
    
}
