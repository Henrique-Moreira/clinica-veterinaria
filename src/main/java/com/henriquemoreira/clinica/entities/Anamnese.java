package com.henriquemoreira.clinica.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name="anamnese")
@Data
public class Anamnese implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToMany(targetEntity = Doenca.class, cascade = CascadeType.ALL)
	private List<Doenca> doencas = new ArrayList<Doenca>();
	
	@NotNull(message = "O campo problemaSistemaDigestivo não pode ser nulo.")
	private String problemaSistemaDigestivo;
	
	@NotNull(message = "O campo problemaSistemaUroGenital não pode ser nulo.")
	private String problemaSistemaUroGenital;
	
	@NotNull(message = "O campo problemaSistemaCardioRepiratorio não pode ser nulo.")
	private String problemaSistemaCardioRepiratorio;
	
	@NotNull(message = "O campo problemaSistemaNeurologico não pode ser nulo.")
	private String problemaSistemaNeurologico;
	
	@NotNull(message = "O campo problemaSistemaLocomotor não pode ser nulo.")
	private String problemaSistemaLocomotor;
	
	@NotNull(message = "O campo problemaPele não pode ser nulo.")
	private String problemaPele;
	
	@NotNull(message = "O campo problemaOlhos não pode ser nulo.")
	private String problemaOlhos;
	
	@NotNull(message = "O campo problemaOuvido não pode ser nulo.")
	private String problemaOuvido;
	
	
}
