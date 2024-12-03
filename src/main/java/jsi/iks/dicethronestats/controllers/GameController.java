package jsi.iks.dicethronestats.controllers;

import jsi.iks.dicethronestats.dto.CreateGameDTO;
import jsi.iks.dicethronestats.services.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class GameController {

	private final GameService gameService;

	@PostMapping
	public ResponseEntity<Void> createGame(@RequestBody CreateGameDTO createGameDTO) {
		gameService.createGame(createGameDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
