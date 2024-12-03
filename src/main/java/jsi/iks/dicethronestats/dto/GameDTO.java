package jsi.iks.dicethronestats.dto;

import java.time.LocalDateTime;

public record GameDTO(int gameId, HeroDTO heroOne, HeroDTO heroTwo, LocalDateTime dateTime) {
}
