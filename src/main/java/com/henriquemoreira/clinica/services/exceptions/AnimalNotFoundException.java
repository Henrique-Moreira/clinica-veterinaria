package com.henriquemoreira.clinica.services.exceptions;

public class AnimalNotFoundException extends RuntimeException {
	public AnimalNotFoundException(Integer id) {
		super("Animal não encontrado. ID = " + id);
	}
}