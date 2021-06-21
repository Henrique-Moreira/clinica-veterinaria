package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.clinica.entities.Anamnese;
import com.henriquemoreira.clinica.repositories.AnamneseRepository;
import com.henriquemoreira.clinica.services.exceptions.AnamneseNotFoundException;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;

	public List<Anamnese> allAnamnese() {
		return repository.findAll();
	}
	
	public Anamnese newAnamnese(Anamnese entity) {
		return repository.save(entity);
	}
	
	public Anamnese updateAnamnese(Integer id, Anamnese entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	
	public Anamnese findByIdAnamnese(Integer id) {
		return repository.findById(id).
				orElseThrow(() -> new AnamneseNotFoundException(id));
	}
	
	public void deleteAnamnese(Integer id) {
		repository.deleteById(id);
	}
	
}
