package jsi.iks.dicethronestats.services;

import jsi.iks.dicethronestats.dto.HeroCardDTO;
import jsi.iks.dicethronestats.dto.HeroDTO;
import jsi.iks.dicethronestats.entities.Hero;
import jsi.iks.dicethronestats.exceptions.HeroNotFoundException;
import jsi.iks.dicethronestats.mapper.HeroCardMapper;
import jsi.iks.dicethronestats.mapper.HeroMapper;
import jsi.iks.dicethronestats.repositories.HeroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HeroService {

	private final HeroRepository heroRepository;

	private final HeroMapper heroMapper;
	private final HeroCardMapper heroCardMapper;

	private Optional<Hero> findById(int id) {
		return heroRepository.findById(id);
	}

	private List<Hero> findAll() {
		return heroRepository.findAll();
	}

	public HeroDTO getById(int id) {
		return heroMapper.toDTO(findById(id)
				.orElseThrow(HeroNotFoundException::new));
	}

	public List<HeroDTO> getAll() {
		return findAll().stream().map(heroMapper::toDTO).toList();
	}

	public List<HeroCardDTO> getAllHeroCards() {
		return findAll().stream().map(heroCardMapper::toDTO).toList();
	}
}
