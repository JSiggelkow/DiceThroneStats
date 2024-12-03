package jsi.iks.dicethronestats.dto;

import java.time.LocalDateTime;

public record CreateGameDTO(HeroDTO heroOne, HeroDTO heroTwo, LocalDateTime dateTime) {
}
