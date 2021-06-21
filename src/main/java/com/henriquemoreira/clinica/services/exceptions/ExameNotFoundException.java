package com.henriquemoreira.clinica.services.exceptions;

public class ExameNotFoundException extends RuntimeException {
	public ExameNotFoundException(Integer id) {
		super("ERRO: O exame de ID " + id + " não existe.");
	}
}