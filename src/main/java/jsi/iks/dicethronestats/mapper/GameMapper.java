package jsi.iks.dicethronestats.mapper;

import jsi.iks.dicethronestats.dto.GameDTO;
import jsi.iks.dicethronestats.entities.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameMapper {

	private final HeroMapper heroMapper;

	public GameDTO toDTO(Game game) {
		return new GameDTO(
				game.getGameId(),
				heroMapper.toDTO(game.getHeroOne()),
				heroMapper.toDTO(game.getHeroTwo()),
				game.getDateTime()
		);
	}
}
