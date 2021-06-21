package com.henriquemoreira.clinica.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Animal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String foto;
	private String raca;
	private String pelagem;
	private int peso;
	private int tipo;
	private Date dataNascimento;
	private Date dataCadastro;
	private int estado;
}
