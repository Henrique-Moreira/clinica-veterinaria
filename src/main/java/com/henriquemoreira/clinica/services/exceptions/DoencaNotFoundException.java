package com.henriquemoreira.clinica.services.exceptions;

public class DoencaNotFoundException extends RuntimeException {
	public DoencaNotFoundException(Integer id) {
		super("ERRO: A doença de ID " + id + " não existe.");
	}
}