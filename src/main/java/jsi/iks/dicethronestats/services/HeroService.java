package jsi.iks.dicethronestats.services;

import jsi.iks.dicethronestats.dto.HeroDTO;
import jsi.iks.dicethronestats.entities.Hero;
import jsi.iks.dicethronestats.mapper.HeroMapper;
import jsi.iks.dicethronestats.repositories.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeroService {

	private final HeroRepository heroRepository;

	private final HeroMapper heroMapper;

	public Optional<Hero> findById(int id) {
		return heroRepository.findById(id);
	}

	private List<Hero> findAll() {
		return heroRepository.findAll();
	}

	public HeroDTO getById(int id) {
		return heroMapper.toDTO(findById(id)
				.orElseThrow(() -> new NoSuchElementException("No Hero with ID: " + id + " found!")));
	}

	public List<HeroDTO> getAll() {
		return findAll().stream().map(heroMapper::toDTO).toList();
	}
}
