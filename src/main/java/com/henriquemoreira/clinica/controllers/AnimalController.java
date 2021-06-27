package com.henriquemoreira.clinica.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquemoreira.clinica.entities.Animal;
import com.henriquemoreira.clinica.services.AnimalService;


@RestController
@RequestMapping(value = "/animal")
public class AnimalController {

	@Autowired
	private AnimalService service;

	// busca os dados de todos os animais
	@GetMapping
	public List<Animal> animals() {
		return service.allAnimals();
	}
	
	// cria os dados de um animal
	@PostMapping
	public ResponseEntity<String> newAnimal(@Valid @RequestBody Animal entity) {
		service.newAnimal(entity);
		return ResponseEntity.ok("Animal cadastrado com sucesso.");
	}
	
	// edita os dados de um animal
	@PutMapping("/{id}")
	public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal entity) {
		return service.updateAnimal(id, entity);
	}
	
	// busca os dados de um animal pelo id
	@GetMapping("/{id}")
	public Animal findByIdAnimal(@PathVariable Integer id) {
		return service.findByIdAnimal(id);
	}
	
	// deleta os dados de um animal passando o id
	@DeleteMapping("/{id}")
	public void deleteAnimalById(@PathVariable Integer id) {
		service.deleteAnimalById(id);
	}
	
}

