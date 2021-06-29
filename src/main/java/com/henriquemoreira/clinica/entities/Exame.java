package com.henriquemoreira.clinica.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.Data;

@Entity
@Table(name="exame")
@Data
public class Exame implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Min(value = 0, message = "Erro: Insira um valor do id do animal superior a 0.")
	private Long animal_id;
	
	@NotNull(message = "Erro: O campo hemograma deve ser true ou false.")
	private Boolean hemograma;
	
	@NotNull(message = "Erro: o campo colesterol deve ser true ou false.")
	private Boolean colesterol;
	
	@NotNull(message = "Erro: o campo fosforo deve ser true ou false.")
	private Boolean fosforo;
	
	@NotNull(message = "Erro: o campo calcio deve ser true ou false.")
	private Boolean calcio;
	
	@NotNull(message = "Erro: o campo glicose deve ser true ou false.")
	private Boolean glicose;
	
	@NotNull(message = "Erro: o campo magnesio deve ser true ou false.")
	private Boolean magnesio;
	
	@NotNull(message = "Erro: o campo ureia deve ser true ou false.")
	private Boolean ureia;
	
	@NotNull(message = "Erro: o campo potassio deve ser true ou false.")
	private Boolean potassio;
	
	@NotNull(message = "O campo ultrassonografia não pode ser nulo.")
	private String ultrassonografia;
	
	@NotNull(message = "O campo radiografia não pode ser nulo.")
	private String radiografia;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String data;
	
}
