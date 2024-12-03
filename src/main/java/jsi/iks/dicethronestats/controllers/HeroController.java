package jsi.iks.dicethronestats.controllers;

import jsi.iks.dicethronestats.dto.HeroDTO;
import jsi.iks.dicethronestats.services.HeroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {

	private final HeroService heroService;

	@GetMapping
	public ResponseEntity<List<HeroDTO>> getAll() {
		List<HeroDTO> heroes = heroService.getAll();
		return ResponseEntity.status(HttpStatus.OK).body(heroes);
	}

	@GetMapping("/{id}")
	public ResponseEntity<HeroDTO> getById(@PathVariable int id) {
		HeroDTO heroDTO = heroService.getById(id);
		return ResponseEntity.status(HttpStatus.OK).body(heroDTO);
	}

}
