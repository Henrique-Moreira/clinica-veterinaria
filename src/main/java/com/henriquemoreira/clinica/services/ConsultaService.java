package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.clinica.entities.Animal;
import com.henriquemoreira.clinica.entities.Consulta;
import com.henriquemoreira.clinica.repositories.AnimalRepository;
import com.henriquemoreira.clinica.repositories.ConsultaRepository;
import com.henriquemoreira.clinica.services.exceptions.AnimalNotFoundException;
import com.henriquemoreira.clinica.services.exceptions.ConsultaNotFoundException;

@Service
public class ConsultaService {

	@Autowired
	private ConsultaRepository repository;

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private AnimalService animalService;
	
	public List<Consulta> allConsultas() {
		return repository.findAll();
	}
	
	public Consulta newConsulta(Consulta entity) {
		repository.save(entity);
		// salvar essa consulta aq na lista de consultas do animal	
		Animal animalAtual = animalRepository.findById(Math.toIntExact(entity.getAnimal_id()))
				.orElseThrow(() -> new AnimalNotFoundException(Math.toIntExact(entity.getAnimal_id())));
	
		animalAtual.getConsultas().add(entity);
		
		animalService.updateAnimal(Math.toIntExact(entity.getAnimal_id()), animalAtual);
		
		return entity;	
	}
	
	public Consulta updateConsultaById(Integer id, Consulta entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	
	public Consulta findConsultaById(Integer id) {
		return repository.findById(id).
				orElseThrow(() -> new ConsultaNotFoundException(id));
	}
	
	public void deleteConsultaById(Integer id) {
		repository.deleteById(id);
	}
}
