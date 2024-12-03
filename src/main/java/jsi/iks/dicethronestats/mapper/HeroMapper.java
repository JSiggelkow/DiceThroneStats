package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.HeroDTO;
import jsi.iks.dicethronestats.entities.Hero;
import jsi.iks.dicethronestats.exceptions.HeroNotFoundException;
import jsi.iks.dicethronestats.repositories.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroMapper {

	private final HeroRepository heroRepository;

	public HeroDTO toDTO(Hero hero) {
		return new HeroDTO(
				hero.getHeroId(),
				hero.getName()
		);
	}

	public Hero toHero(HeroDTO heroDTO) {
		return heroRepository.findById(heroDTO.heroId())
				.orElseThrow(HeroNotFoundException::new);
	}
}
