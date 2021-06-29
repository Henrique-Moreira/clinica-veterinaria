package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.clinica.entities.Animal;
import com.henriquemoreira.clinica.entities.Exame;
import com.henriquemoreira.clinica.repositories.AnimalRepository;
import com.henriquemoreira.clinica.repositories.ExameRepository;
import com.henriquemoreira.clinica.services.exceptions.AnimalNotFoundException;
import com.henriquemoreira.clinica.services.exceptions.ExameNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repository;

	@Autowired
	private AnimalRepository animalRepository;
	
	@Autowired
	private AnimalService animalService;

	public List<Exame> allExames() {
		return repository.findAll();
	}

	public Exame newExame(Exame entity) {
		repository.save(entity);
		// salvar esse exame aq na lista de exames do animal	
		Animal animalAtual = animalRepository.findById(Math.toIntExact(entity.getAnimal_id()))
				.orElseThrow(() -> new AnimalNotFoundException(Math.toIntExact(entity.getAnimal_id())));
	
		animalAtual.getExames().add(entity);
		
		animalService.updateAnimal(Math.toIntExact(entity.getAnimal_id()), animalAtual);
		
		return entity;			
	}

	public Exame updateExameById(Integer id, Exame entity) {
		entity.setId(id);
		return repository.save(entity);
	}

	public Exame findExameById(Integer id) {
		return repository.findById(id).orElseThrow(() -> new ExameNotFoundException(id));
	}

	public void deleteExameById(Integer id) {
		repository.deleteById(id);
	}

//	public List<Exame> searchExamsByIdAnimal(Integer id) {
//		return repository.searchExamsByIdAnimal(id);
//	}
}
