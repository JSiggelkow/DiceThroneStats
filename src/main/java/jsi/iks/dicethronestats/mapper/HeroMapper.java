package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.HeroDTO;
import jsi.iks.dicethronestats.entities.Hero;
import jsi.iks.dicethronestats.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroMapper {

	private final HeroService heroService;

	public HeroDTO toDTO(Hero hero) {
		return new HeroDTO(
				hero.getHeroId(),
				hero.getName()
		);
	}

	public Hero toHero(HeroDTO heroDTO) {
		return heroService.getById(heroDTO.heroId());
	}
}
