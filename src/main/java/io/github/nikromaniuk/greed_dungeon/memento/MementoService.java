package io.github.nikromaniuk.greed_dungeon.memento;

import io.github.nikromaniuk.greed_dungeon.memento.dto.*;
import io.github.nikromaniuk.greed_dungeon.memento.mappers.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MementoService
{
    private final MementoRepository mementoRepository;
    private final MementoWebMapper mementoWebMapper;
    private final MementoPersistenceMapper mementoPersistenceMapper;

    public MementoService(
            MementoRepository mementoRepository,
            MementoWebMapper mementoWebMapper,
            MementoPersistenceMapper mementoPersistenceMapper)
    {
        this.mementoRepository = mementoRepository;
        this.mementoWebMapper = mementoWebMapper;
        this.mementoPersistenceMapper = mementoPersistenceMapper;
    }

    public List<MementoResponseDto> getAllMementos()
    {
        List<MementoEntity> entities = mementoRepository.findAll();

        List<Memento> domains = entities.stream()
                .map(mementoPersistenceMapper::toDomain)
                .toList();

        return domains.stream()
                .map(mementoWebMapper::toResponse)
                .toList();
    }

    public void createMemento(MementoCreateDto dto)
    {
        if (dto == null) { return; }

        // DTO -> Domain
        Memento domain = mementoWebMapper.toDomain(dto);

        // Domain -> Entity
        MementoEntity entity = mementoPersistenceMapper.toEntity(domain);

        // Save Entity
        mementoRepository.save(entity);
    }
}
