package com.henriquemoreira.clinica.services.exceptions;

public class DoencaAlreadyExistsIntoAnamneseException extends RuntimeException {
	public DoencaAlreadyExistsIntoAnamneseException(Integer idAnamnese, Integer idDoenca) {
		super("A doença de id " + idDoenca + " já foi inserida na Anamnese de id " + idAnamnese);
	}
}