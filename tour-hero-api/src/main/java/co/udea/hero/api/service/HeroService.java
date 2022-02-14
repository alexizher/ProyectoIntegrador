package co.udea.hero.api.service;

import co.udea.hero.api.model.Hero;

import java.util.Optional;

@service
public class HeroService {
    private HeroRepository heroRepository;

    public heroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
    }

    public Hero getHero(Integer id){
        Optional<Hero> optionalHero = heroRepository.findById(id);
        return optionalHero.get();
    }
}
