package jsi.iks.dicethronestats.dto;

import java.time.LocalDateTime;

public record CreateGameDTO(int heroOneId, int heroTwoId, LocalDateTime dateTime) {
}
