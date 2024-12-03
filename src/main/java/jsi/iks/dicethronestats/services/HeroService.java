package jsi.iks.dicethronestats.services;

import jsi.iks.dicethronestats.entities.Hero;
import jsi.iks.dicethronestats.repositories.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeroService {

	private final HeroRepository heroRepository;

	private Optional<Hero> findById(int id) {
		return heroRepository.findById(id);
	}

	public Hero getById(int id) {
		return findById(id).orElseThrow(() -> new NoSuchElementException("No Hero with ID: " + id + "found!"));
	}
}
