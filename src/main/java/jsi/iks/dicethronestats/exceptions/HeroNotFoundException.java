package jsi.iks.dicethronestats.exceptions;

public class HeroNotFoundException extends RuntimeException {

	public HeroNotFoundException() {
		super("Hero was not found!");
	}
}
