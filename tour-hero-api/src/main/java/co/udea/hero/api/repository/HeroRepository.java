package co.udea.hero.api.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Integer>{
}
