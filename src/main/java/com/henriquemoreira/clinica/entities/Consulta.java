package com.henriquemoreira.clinica.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name="consulta")
@Data
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O campo animal_id não pode ser nulo.")
	private Long animal_id;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String data;
	
	@NotNull(message = "O campo observacoes não pode ser nulo.")
	private String observacoes;
	
	@NotNull(message = "O campo queixa não pode ser nulo.")
	private String queixa;
	
	@NotNull(message = "O campo historico não pode ser nulo.")
	private String historico;
	
	@OneToOne
	private Anamnese anamnese;
}
