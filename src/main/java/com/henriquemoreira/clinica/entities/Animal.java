package com.henriquemoreira.clinica.entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="animal")
@Data
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O campo foto não pode ser nulo.")
	private String foto;
	
	@NotNull(message = "O campo raca não pode ser nulo.")
	private String raca;
	
	@NotNull(message = "O campo pelagem não pode ser nulo.")
	private String pelagem;
	
	@NotNull(message = "O campo peso não pode ser nulo.")
	private int peso;
	private int tipo;
	
	@NotNull(message = "O campo dataNascimento não pode ser nulo.")
	private Date dataNascimento;
	
	@NotNull(message = "O campo dataCadastro não pode ser nulo.")
	private Date dataCadastro;
	
	private int estado;
	
	@OneToMany
	private List<Exame> exames = new ArrayList<Exame>();
	
	@OneToMany
	private List<Consulta> consultas = new ArrayList<Consulta>();
}
