package com.henriquemoreira.clinica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.henriquemoreira.clinica.entities.Exame;
import com.henriquemoreira.clinica.services.ExameService;


@RestController
@RequestMapping(value = "/exame")
public class ExameController {

	@Autowired
	private ExameService service;

	// busca todos os exames
	@GetMapping
	public List<Exame> exames() {
		return service.allExames();
	}
	
	// cria os dados de um exame
	@PostMapping
	public Exame newExame(@RequestBody Exame entity) {
		return service.newExame(entity);
	}
	
	// edita os dados de um exame
	@PutMapping("/{id}")
	public Exame updateExameById(@PathVariable Integer id, @RequestBody Exame entity) {
		return service.updateExameById(id, entity);
	}
	
	// busca os dados de um exame pelo id
	@GetMapping("/{id}")
	public Exame findExameById(@PathVariable Integer id) {
		return service.findExameById(id);
	}
	
	// deleta os dados de um exame passando o id
	@DeleteMapping("/{id}")
	public void deleteExameById(@PathVariable Integer id) {
		service.deleteExameById(id);
	}
	
	@GetMapping("/all/{id}")
	public List<Exame> searchExamsByIdAnimal(@PathVariable Integer id) {
		return service.searchExamsByIdAnimal(id);
	}
}

