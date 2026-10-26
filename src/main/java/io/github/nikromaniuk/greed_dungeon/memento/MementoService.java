package io.github.nikromaniuk.greed_dungeon.memento;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MementoService
{
    private final MementoRepository mementoRepository;

    public MementoService(MementoRepository mementoRepository)
    {
        this.mementoRepository = mementoRepository;
    }

    public List<MementoEntity> getAllMementos()
    {
        return mementoRepository.findAll();
    }

    public void createMemento(CreateMementoDto request)
    {
        if (request == null) { return; }

        // --- Create Empty Object ---

        MementoEntity tempMemento = new MementoEntity();
        MementoEntity savedMemento = mementoRepository.save(tempMemento); // Save & store new hero into the DB

        // --- Add Details To Object---

        savedMemento.setName(request.name());

        // --- Save Detailed Object ---

        mementoRepository.save(savedMemento);
    }
}
