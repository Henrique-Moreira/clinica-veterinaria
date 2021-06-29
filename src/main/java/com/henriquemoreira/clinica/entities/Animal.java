package com.henriquemoreira.clinica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
	
	@Digits(integer= 3, fraction= 4, message = "Erro: Insira o valor de peso do animal entre 0 e 1000.")
	@Min(value = 0, message = "Erro: Insira um valor superior a 0.")
	private Double peso;
	
	@Min(value = 0, message = "Erro: Insira um valor superior a 0.")
	private int tipo;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String dataNascimento;
	
	@Pattern(regexp = "^((19|2[0-9])[0-9]{2})-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])$", message = "A data deve conter o formato aaaa-mm-dd")
	private String dataCadastro;
	
	private int estado;
	
	@OneToMany
	private List<Exame> exames = new ArrayList<Exame>();
	
	@OneToMany
	private List<Consulta> consultas = new ArrayList<Consulta>();
}
