package com.henriquemoreira.clinica.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
	
	@NotNull(message = "O campo data não pode ser nulo.")
	private Date data;
	
	@NotNull(message = "O campo observacoes não pode ser nulo.")
	private String observacoes;
	
	@NotNull(message = "O campo queixa não pode ser nulo.")
	private String queixa;
	
	@NotNull(message = "O campo historico não pode ser nulo.")
	private String historico;
	
	@OneToOne
	private Anamnese anamnese;
}
