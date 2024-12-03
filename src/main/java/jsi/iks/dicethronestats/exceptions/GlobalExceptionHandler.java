package jsi.iks.dicethronestats.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(HeroNotFoundException.class)
	public ResponseEntity<ErrorObject> handleHeroNotFoundException(HeroNotFoundException ex) {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(new ErrorObject(HttpStatus.NOT_FOUND.value(), ex.getMessage(), LocalDateTime.now()));
	}
}
