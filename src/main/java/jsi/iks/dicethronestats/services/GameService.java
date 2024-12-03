package jsi.iks.dicethronestats.services;

import jsi.iks.dicethronestats.dto.CreateGameDTO;
import jsi.iks.dicethronestats.dto.GameDTO;
import jsi.iks.dicethronestats.entities.Game;
import jsi.iks.dicethronestats.mapper.CreateGameMapper;
import jsi.iks.dicethronestats.mapper.GameMapper;
import jsi.iks.dicethronestats.repositories.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {

	private final GameRepository gameRepository;
	private final CreateGameMapper createGameMapper;
	private final GameMapper gameMapper;

	private void save(Game game) {
		gameRepository.save(game);
	}

	private List<Game> findAll() {
		return gameRepository.findAll();
	}

	public void createGame(CreateGameDTO createGameDTO) {
		save(createGameMapper.toGame(createGameDTO));
	}

	public List<GameDTO> getAll() {
		return findAll().stream().map(gameMapper::toDTO).toList();
	}
}
