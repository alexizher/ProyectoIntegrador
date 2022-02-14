package co.udea.hero.api.service;

import co.udea.hero.api.model.Hero;
import co.udea.hero.api.repository.HeroRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.misc.resources.Messages;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class HeroService {

    private final Logger log = LoggerFactory.getLogger(HeroService.class);
    private HeroRepository heroRepository;
    private Messages messages;

    public HeroService(HeroRepository heroRepository){
        this.heroRepository = heroRepository;
        this.messages = messages;
    }

    public Hero getHero(Integer id){
        Optional<Hero> optionalHero = heroRepository.findById(id);
        if(!optionalHero.isPresent()){
            log.info("No se encuentra un heroe con ID: "+id);
            throw new BusinessException(messages.get("exception.data_not_found.hero"));
        }
        return optionalHero.get();
    }

    public List<Hero> getHeroes(){
        List<Hero> heroesList = heroRepository.findAll();
        return heroesList;
    }
}
