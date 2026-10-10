package io.github.nikromaniuk.greed_dungeon.hero;

import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<HeroEntity, Integer>
{

}
