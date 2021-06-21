package com.henriquemoreira.clinica.services.exceptions;

public class ConsultaNotFoundException extends RuntimeException {
	public ConsultaNotFoundException(Integer id) {
		super("ERRO: A consulta de ID " + id + " não existe.");
	}
}