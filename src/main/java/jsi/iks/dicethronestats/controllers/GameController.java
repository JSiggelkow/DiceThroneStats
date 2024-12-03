package jsi.iks.dicethronestats.controllers;

import jsi.iks.dicethronestats.dto.CreateGameDTO;
import jsi.iks.dicethronestats.dto.GameDTO;
import jsi.iks.dicethronestats.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameController {

	private final GameService gameService;

	@PostMapping
	public ResponseEntity<Void> create(@RequestBody CreateGameDTO createGameDTO) {
		gameService.createGame(createGameDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	@GetMapping
	public ResponseEntity<List<GameDTO>> getAll() {
		List<GameDTO> games = gameService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(games);
	}
}
