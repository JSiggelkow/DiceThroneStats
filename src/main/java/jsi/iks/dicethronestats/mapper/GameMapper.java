package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.GameDTO;
import jsi.iks.dicethronestats.entities.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper {

	public static GameDTO toDTO(Game game) {
		return new GameDTO(
				game.getGameId(),
				game.getHeroOne(),
				game.getHeroTwo(),
				game.getDateTime()
		);
	}
}
