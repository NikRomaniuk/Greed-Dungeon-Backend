package io.github.nikromaniuk.greed_dungeon.hero;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/hero")
public class HeroController
{
    private final HeroService service;

    public HeroController(HeroService heroService)
    {
        this.service = heroService;
    }

    @GetMapping
    public List<HeroResponseDto> getAllHeroes()
    {
        return service.getAllHeroes();
    }

    @PostMapping
    public void createHero(@RequestBody CreateHeroDto request)
    {
        service.createHero(request);
    }
}
