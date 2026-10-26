package io.github.nikromaniuk.greed_dungeon.hero;

import io.github.nikromaniuk.greed_dungeon.floor.FloorEntity;
import io.github.nikromaniuk.greed_dungeon.floor.FloorRepository;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoDto;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMementoEntity;
import io.github.nikromaniuk.greed_dungeon.memento.MementoEntity;
import io.github.nikromaniuk.greed_dungeon.memento.MementoRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HeroService
{
    private final HeroRepository heroRepository;
    private final FloorRepository floorRepository;
    private final MementoRepository mementoRepository;

    public HeroService( HeroRepository heroRepository,
                        FloorRepository floorRepository,
                        MementoRepository mementoRepository)
    {
        this.heroRepository = heroRepository;
        this.floorRepository = floorRepository;
        this.mementoRepository = mementoRepository;
    }

    public List<HeroResponseDto> getAllHeroes()
    {
        List<HeroEntity> entities = heroRepository.findAll();
        List<HeroResponseDto> responses = new ArrayList<>();

        for( HeroEntity entity : entities )
        {
            responses.add(HeroResponseDto.fromEntity(entity));
        }

        return responses;
    }

    public void createHero(CreateHeroDto request)
    {
        if (request == null) { return; }

        // --- Create Empty Hero ---

        HeroEntity tempHero = new HeroEntity();
        HeroEntity savedHero = heroRepository.save(tempHero); // Save & store new hero into the DB

        // --- Add Requested Floor ---

        FloorEntity foundFloor = floorRepository.findById(request.floorId())
                .orElseThrow(() -> new RuntimeException("Requested Floor not found"));

        savedHero.setFloor(foundFloor);

        // --- Add Requested Mementos Records ---

        if (!request.mementos().isEmpty())
        {
            for (HeroMementoDto requestedMemento : request.mementos())
            {
                MementoEntity foundMemento = mementoRepository.findById(requestedMemento.mementoId())
                        .orElseThrow(() -> new RuntimeException("Requested Memento not found"));

                HeroMementoEntity heroMemento = new HeroMementoEntity();
                heroMemento.setHero(savedHero);
                heroMemento.setMemento(foundMemento);
                heroMemento.setLevel(requestedMemento.level());

                savedHero.addMemento(heroMemento);
            }
        }

        // --- Save Detailed Hero ---

        heroRepository.save(savedHero);
    }
}
