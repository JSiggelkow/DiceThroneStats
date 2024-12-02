package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.HeroDTO;
import jsi.iks.dicethronestats.entities.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HeroMapper {

	public static HeroDTO toDTO(Hero hero) {
		return new HeroDTO(
				hero.getHeroId(),
				hero.getName()
		);
	}
}
