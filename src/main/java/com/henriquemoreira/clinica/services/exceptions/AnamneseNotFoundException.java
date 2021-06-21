package com.henriquemoreira.clinica.services.exceptions;

public class AnamneseNotFoundException extends RuntimeException {
	public AnamneseNotFoundException(Integer id) {
		super("Anamnese não encontrada. ID = " + id);
	}
}