package io.github.nikromaniuk.greed_dungeon.memento;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/memento")
public class MementoController
{
    private final MementoService service;

    public MementoController(MementoService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<MementoEntity> getAllMementos()
    {
        return service.getAllMementos();
    }

    @PostMapping
    public void createMemento(@RequestBody CreateMementoDto request)
    {
        service.createMemento(request);
    }
}
