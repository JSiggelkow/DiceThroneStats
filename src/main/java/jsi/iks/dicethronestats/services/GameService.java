package jsi.iks.dicethronestats.services;

import jsi.iks.dicethronestats.dto.CreateGameDTO;
import jsi.iks.dicethronestats.entities.Game;
import jsi.iks.dicethronestats.mapper.CreateGameMapper;
import jsi.iks.dicethronestats.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;

	private void save(Game game) {
		gameRepository.save(game);
	}

	private Optional<Game> findById(int id) {
		return gameRepository.findById(id);
	}

	public boolean createGame(CreateGameDTO createGameDTO) {
		save(CreateGameMapper.toGame(createGameDTO));
		return true;
	}
}
