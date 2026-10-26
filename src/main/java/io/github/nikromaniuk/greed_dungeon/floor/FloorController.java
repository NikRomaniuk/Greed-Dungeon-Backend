package io.github.nikromaniuk.greed_dungeon.floor;

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
    public List<FloorEntity> getAllFloors()
    {
        return service.getAllFloors();
    }

    @PostMapping
    public void createFloor(@RequestBody CreateFloorRequest request)
    {
        service.createFloor(request);
    }
}
