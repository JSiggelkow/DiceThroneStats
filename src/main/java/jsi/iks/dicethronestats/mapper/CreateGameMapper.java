package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.CreateGameDTO;
import jsi.iks.dicethronestats.entities.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateGameMapper {

	public static Game toGame(CreateGameDTO createGameDTO) {
		Game game = new Game();
		game.setHeroOne(createGameDTO.heroOneId());
		game.setHeroTwo(createGameDTO.heroTwoId());
		game.setDateTime(createGameDTO.dateTime());
		return game;
	}
}
