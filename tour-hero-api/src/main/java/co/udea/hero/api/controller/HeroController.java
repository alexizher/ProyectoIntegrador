package co.udea.hero.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heroes")
public class HeroController {
    private HeroService heroService;

    public HeroController(HeroService heroService){
        this.heroService = heroService;
    }

}
