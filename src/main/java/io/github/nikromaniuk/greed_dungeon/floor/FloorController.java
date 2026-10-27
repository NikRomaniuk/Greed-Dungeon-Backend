package io.github.nikromaniuk.greed_dungeon.floor;

import io.github.nikromaniuk.greed_dungeon.floor.dto.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/floor")
public class FloorController
{
    private final FloorService service;

    public FloorController(FloorService floorService)
    {
        this.service = floorService;
    }

    @GetMapping
    public List<FloorResponseDto> getAllFloors()
    {
        return service.getAllFloors();
    }

    @PostMapping
    public void createFloor(@RequestBody FloorCreateDto request)
    {
        service.createFloor(request);
    }
}
