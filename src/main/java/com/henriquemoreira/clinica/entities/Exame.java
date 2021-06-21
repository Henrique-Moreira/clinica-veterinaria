package com.henriquemoreira.clinica.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="exame")
@Data
public class Exame implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	private Animal animal;
	
	private boolean hemograma;
	private boolean colesterol;
	private boolean fosforo;
	private boolean calcio;
	private boolean glicose;
	private boolean magnesio;
	private boolean ureia;
	private boolean potassio;
	private String ultrassonografia;
	private String radiografia;
	private Date data;
	

}
