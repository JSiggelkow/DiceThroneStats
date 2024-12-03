package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.CreateGameDTO;
import jsi.iks.dicethronestats.entities.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateGameMapper {

	private final HeroMapper heroMapper;

	public Game toGame(CreateGameDTO createGameDTO) {
		Game game = new Game();
		game.setHeroOne(heroMapper.toHero(createGameDTO.heroOne()));
		game.setHeroTwo(heroMapper.toHero(createGameDTO.heroTwo()));
		game.setDateTime(createGameDTO.dateTime());
		return game;
	}
}
