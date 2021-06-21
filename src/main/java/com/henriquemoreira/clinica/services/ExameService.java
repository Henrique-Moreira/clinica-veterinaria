package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.clinica.entities.Exame;
import com.henriquemoreira.clinica.repositories.ExameRepository;
import com.henriquemoreira.clinica.services.exceptions.ExameNotFoundException;

@Service
public class ExameService {

	@Autowired
	private ExameRepository repository;

	public List<Exame> allExames() {
		return repository.findAll();
	}
	
	public Exame newExame(Exame entity) {
		return repository.save(entity);
	}
	
	public Exame updateExameById(Integer id, Exame entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	
	public Exame findExameById(Integer id) {
		return repository.findById(id).
				orElseThrow(() -> new ExameNotFoundException(id));
	}
	
	public void deleteExameById(Integer id) {
		repository.deleteById(id);
	}
	
	public List<Exame> searchExamsByIdAnimal(Integer id) {
		return repository.searchExamsByIdAnimal(id);
	}
}
