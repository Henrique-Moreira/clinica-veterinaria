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

import com.henriquemoreira.clinica.entities.Doenca;
import com.henriquemoreira.clinica.services.DoencaService;

@RestController
@RequestMapping(value = "/doenca")
public class DoencaController {

	@Autowired
	private DoencaService service;

	// busca todas as doencas
	@GetMapping
	public List<Doenca> animals() {
		return service.allDoencas();
	}
	
	// cria os dados de uma doença
	@PostMapping
	public ResponseEntity<String> newDoenca(@Valid @RequestBody Doenca entity) {
		service.newDoenca(entity);
		return ResponseEntity.ok("Doença cadastrada com sucesso.");
	}
	
	// edita os dados de uma doença
	@PutMapping("/{id}")
	public Doenca updateDoencaById(@PathVariable Integer id, @RequestBody Doenca entity) {
		return service.updateDoencaById(id, entity);
	}
	
	// busca os dados de uma doenca pelo id
	@GetMapping("/{id}")
	public Doenca findDoencaById(@PathVariable Integer id) {
		return service.findDoencaById(id);
	}
	
	// deleta os dados de uma doenca passando o id
	@DeleteMapping("/{id}")
	public void deleteDoencaById(@PathVariable Integer id) {
		service.deleteDoencaById(id);
	}
	
}

