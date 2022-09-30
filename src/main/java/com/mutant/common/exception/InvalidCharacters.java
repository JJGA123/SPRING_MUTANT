package com.mutant.common.exception;

public class InvalidCharacters extends RuntimeException {

	public InvalidCharacters(String details) {
		super(details);
	}

	private static final long serialVersionUID = 1L;

}