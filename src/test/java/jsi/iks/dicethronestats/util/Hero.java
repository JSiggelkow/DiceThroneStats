package jsi.iks.dicethronestats.util;

import jsi.iks.dicethronestats.dto.HeroDTO;
import lombok.Getter;

@Getter
public enum Hero {
	BARBARIAN(1,"Barbarian"),
	MOON_ELF(2,"Moon Elf"),
	PYROMANCER(3,"Pyromancer"),
	SHADOW_THIEF(4,"Shadow Thief"),
	MONK(5,"Monk"),
	PALADIN(6,"Paladin"),
	NINJA(7,"Ninja"),
	TREANT(8,"Treant"),
	CURSED_PIRATE(9,"Cursed Pirate"),
	ARTIFICER(10,"Artificer"),
	SERAPH(11,"Seraph"),
	VAMPIRE_LORD(12,"Vampire Lord"),
	GUNSLINGER(13,"Gunslinger"),
	SAMURAI(14,"Samurai"),
	TACTICIAN(15,"Tactician"),
	HUNTRESS(16,"Huntress"),
	BLACK_PANTHER(17,"Black Panther"),
	CAPTAIN_MARVEL(18,"Captain Marvel"),
	BLACK_WIDOW(19,"Black Widow"),
	DOCTOR_STRANGE(20,"Doctor Strange"),
	SCARLET_WITCH(21,"Scarlet Witch"),
	LOKI(22,"Loki"),
	THOR(23,"Thor"),
	SPIDERMAN(24,"Spider-Man"),
	KRAMPUS(25,"Krampus"),
	SANTA(26,"Santa");

	private final HeroDTO heroDTO;

	Hero(int heroId, String name) {
		heroDTO = new HeroDTO(heroId,name);
	}
}

