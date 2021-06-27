package com.henriquemoreira.clinica.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="exame")
@Data
public class Exame implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O campo animal_id não pode ser nulo.")
	private Long animal_id;
	
	@NotNull(message = "O campo hemograma não pode ser nulo.")
	private boolean hemograma;
	
	@NotNull(message = "O campo colesterol não pode ser nulo.")
	private boolean colesterol;
	
	@NotNull(message = "O campo fosforo não pode ser nulo.")
	private boolean fosforo;
	
	@NotNull(message = "O campo calcio não pode ser nulo.")
	private boolean calcio;
	
	@NotNull(message = "O campo glicose não pode ser nulo.")
	private boolean glicose;
	
	@NotNull(message = "O campo magnesio não pode ser nulo.")
	private boolean magnesio;
	
	@NotNull(message = "O campo ureia não pode ser nulo.")
	private boolean ureia;
	
	@NotNull(message = "O campo potassio não pode ser nulo.")
	private boolean potassio;
	
	@NotNull(message = "O campo ultrassonografia não pode ser nulo.")
	private String ultrassonografia;
	
	@NotNull(message = "O campo radiografia não pode ser nulo.")
	private String radiografia;
	
	@NotNull(message = "O campo data não pode ser nulo.")
	private Date data;
	
}
