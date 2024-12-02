package jsi.iks.dicethronestats.dto;

import java.time.LocalDateTime;

public record GameDTO(int gameId, int heroOne, int heroTwo, LocalDateTime dateTime) {
}
