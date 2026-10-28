package io.github.nikromaniuk.greed_dungeon.hero;

import io.github.nikromaniuk.greed_dungeon.floor.Floor;
import io.github.nikromaniuk.greed_dungeon.floor.FloorService;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroCreateDto;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroResponseDto;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroVerbalDto;
import io.github.nikromaniuk.greed_dungeon.hero.mappers.HeroPersistenceMapper;
import io.github.nikromaniuk.greed_dungeon.hero.mappers.HeroWebMapper;
import io.github.nikromaniuk.greed_dungeon.hero_memento.HeroMemento;
import io.github.nikromaniuk.greed_dungeon.hero_memento.dto.HeroMementoCreateDto;
import io.github.nikromaniuk.greed_dungeon.hero_memento.mappers.HeroMementoWebMapper;
import io.github.nikromaniuk.greed_dungeon.memento.Memento;
import io.github.nikromaniuk.greed_dungeon.memento.MementoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HeroService
{
    private final HeroRepository heroRepository;
    private final HeroWebMapper heroWebMapper;
    private final HeroPersistenceMapper heroPersistenceMapper;
    private final HeroMementoWebMapper heroMementoWebMapper;
    private final FloorService floorService;
    private final MementoService mementoService;

    public HeroService(
            HeroRepository heroRepository,
            HeroWebMapper heroWebMapper,
            HeroPersistenceMapper heroPersistenceMapper,
            HeroMementoWebMapper heroMementoWebMapper,
            FloorService floorService,
            MementoService mementoService)
    {
        this.heroRepository = heroRepository;
        this.heroWebMapper = heroWebMapper;
        this.heroPersistenceMapper = heroPersistenceMapper;
        this.heroMementoWebMapper = heroMementoWebMapper;
        this.floorService = floorService;
        this.mementoService = mementoService;
    }

    public List<HeroResponseDto> getAllHeroes()
    {
        List<HeroEntity> entities = heroRepository.findAll();

        List<Hero> domains = entities.stream()
                .map(heroPersistenceMapper::toDomain)
                .toList();

        return domains.stream()
                .map(heroWebMapper::toResponse)
                .toList();
    }

    public List<HeroVerbalDto> getAllHeroesVerbal()
    {
        List<HeroEntity> entities = heroRepository.findAll();

        List<Hero> domains = entities.stream()
                .map(heroPersistenceMapper::toDomain)
                .toList();

        return domains.stream()
                .map(heroWebMapper::toVerbal)
                .toList();
    }

    public void createHero(HeroCreateDto dto)
    {
        if (dto == null) { return; }

        // --- Resolve Requested Floor ---

        Floor floor = floorService.getDomainFloor(dto.floorId());

        // --- Resolve Requested Mementos & Build HeroMementos ---

        List<HeroMemento> mementos = new ArrayList<>();

        if (dto.mementos() != null)
        {
            for (HeroMementoCreateDto requestedMemento : dto.mementos())
            {
                Memento memento = mementoService.getDomainMemento(requestedMemento.mementoId());

                mementos.add(heroMementoWebMapper.toDomain(requestedMemento, memento));
            }
        }

        // DTO (with resolved references) -> Domain
        Hero domain = heroWebMapper.toDomain(dto, floor, mementos);

        // Domain -> Entity
        HeroEntity entity = heroPersistenceMapper.toEntity(domain);

        // Re-link back references required by the @OneToMany(mappedBy = "hero") mapping
        entity.getMementos().forEach(heroMementoEntity -> heroMementoEntity.setHero(entity));

        // Save Entity
        heroRepository.save(entity);
    }
}
