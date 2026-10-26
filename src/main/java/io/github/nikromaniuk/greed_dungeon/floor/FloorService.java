package io.github.nikromaniuk.greed_dungeon.floor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorService
{
    private final FloorRepository floorRepository;

    public FloorService(FloorRepository floorRepository)
    {
        this.floorRepository = floorRepository;
    }

    public List<FloorEntity> getAllFloors()
    {
        return floorRepository.findAll();
    }

    public void createFloor(CreateFloorRequest request)
    {
        if (request == null) { return; }

        // --- Create Empty Object ---

        FloorEntity tempFloor = new FloorEntity();
        FloorEntity savedFloor = floorRepository.save(tempFloor); // Save & store new floor into the DB

        // --- Add Details To Object ---

        savedFloor.setDepth(request.depth());
        savedFloor.setName(request.name());

        // --- Save Detailed Object ---

        floorRepository.save(savedFloor);
    }
}
