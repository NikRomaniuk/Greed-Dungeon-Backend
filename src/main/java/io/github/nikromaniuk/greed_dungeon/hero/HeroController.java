package io.github.nikromaniuk.greed_dungeon.hero;


import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroCreateDto;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroResponseDto;
import io.github.nikromaniuk.greed_dungeon.hero.dto.HeroVerbalDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/verbal")
    public List<HeroVerbalDto> getAllHeroesVerbal()
    {
        return service.getAllHeroesVerbal();
    }

    @PostMapping
    public void createHero(@RequestBody HeroCreateDto request)
    {
        service.createHero(request);
    }
}
