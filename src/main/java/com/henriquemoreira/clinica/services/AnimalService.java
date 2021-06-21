package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.clinica.entities.Animal;
import com.henriquemoreira.clinica.repositories.AnimalRepository;
import com.henriquemoreira.clinica.services.exceptions.AnimalNotFoundException;

@Service
public class AnimalService {

	@Autowired
	private AnimalRepository repository;

	public List<Animal> allAnimals() {
		return repository.findAll();
	}
	
	public Animal newAnimal(Animal entity) {
		return repository.save(entity);
	}
	
	public Animal updateAnimal(Integer id, Animal entity) {
		entity.setId(id);
		return repository.save(entity);
	}
	
	public Animal findByIdAnimal(Integer id) {
		return repository.findById(id).
				orElseThrow(() -> new AnimalNotFoundException(id));
	}
	
	public void deleteAnimalById(Integer id) {
		repository.deleteById(id);
	}
}
