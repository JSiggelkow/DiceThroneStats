package jsi.iks.dicethronestats.exceptions;


import java.time.LocalDateTime;

public record ErrorObject(int status, String message, LocalDateTime localDateTime) {
}
