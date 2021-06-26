package com.henriquemoreira.clinica.services.exceptions;

public class DoencaExceptionOfLimitInserted extends RuntimeException {
	public DoencaExceptionOfLimitInserted() {
		super("ERRO: O limite máximo de doenças é de 5!");
	}
}