package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.HeroCardDTO;
import jsi.iks.dicethronestats.entities.Hero;
import org.springframework.stereotype.Component;

@Component
public class HeroCardMapper {

	public HeroCardDTO toDTO(Hero hero) {
		return new HeroCardDTO(hero.getName(), hero.getSeason(), hero.getDifficulty(), hero.getGames());
	}
}
