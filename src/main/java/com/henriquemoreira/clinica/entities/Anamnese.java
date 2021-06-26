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
	
	private String problemaSistemaDigestivo;
	private String problemaSistemaUroGenital;
	private String problemaSistemaCardioRepiratorio;
	private String problemaSistemaNeurologico;
	private String problemaSistemaLocomotor;
	private String problemaPele;
	private String problemaOlhos;
	private String problemaOuvido;
	
}
