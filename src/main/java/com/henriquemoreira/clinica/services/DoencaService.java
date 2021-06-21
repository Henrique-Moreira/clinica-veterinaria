package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.clinica.entities.Doenca;
import com.henriquemoreira.clinica.repositories.DoencasRepository;
import com.henriquemoreira.clinica.services.exceptions.DoencaNotFoundException;

@Service
public class DoencaService {

	@Autowired
	private DoencasRepository repository;

	public List<Doenca> allDoencas() {
		return repository.findAll();
	}
	
	public Doenca newDoenca(Doenca entity) {
		return repository.save(entity);
	}
	
	public Doenca updateDoencaById(Integer id, Doenca entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	
	public Doenca findDoencaById(Integer id) {
		return repository.findById(id).
				orElseThrow(() -> new DoencaNotFoundException(id));
	}
	
	public void deleteDoencaById(Integer id) {
		repository.deleteById(id);
	}
}
