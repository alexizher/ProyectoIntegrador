package co.udea.hero.api.controller;

import co.udea.hero.api.model.Hero;
import co.udea.hero.api.service.HeroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    private final Logger log = LoggerFactory.getLogger(HeroController.class);

    private HeroService heroService;

    public HeroController(HeroService heroService){
        this.heroService = heroService;
    }

    /**
     * Busca un heroe creado en la DB po su ID
     */
    @GetMapping("{id}")
    @ApiOperation(value = " Buscar un heroe por su id",  response = Hero.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Hero encontrado existosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
    public ResponseEntity<Hero> getHero(@PathVariable Integer id){
        log.info("Rest request buscar heroe por ID: "+ id);
        return ResponseEntity.ok(heroService.getHero(id));
    }

    /**
     * lista todos los heroes creados en la DB
     */
    @GetMapping("")
    @ApiOperation(value = " Buscar todos los heroes",  response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Heroes encontrados existosamente"),
            @ApiResponse(code = 400, message = "La petición es inválida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")
    })
       public ResponseEntity<List<Hero>> getHeroes(){
        log.info("Rest request Buscar Heroes");
        return ResponseEntity.ok(heroService.getHeroes());
    }

}
