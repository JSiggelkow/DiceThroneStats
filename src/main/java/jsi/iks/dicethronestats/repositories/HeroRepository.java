package jsi.iks.dicethronestats.repositories;

import jsi.iks.dicethronestats.entities.Hero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeroRepository extends JpaRepository<Hero, Integer> {
}
