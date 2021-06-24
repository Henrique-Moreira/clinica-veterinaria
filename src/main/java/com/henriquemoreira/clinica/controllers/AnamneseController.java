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

import com.henriquemoreira.clinica.entities.Anamnese;
import com.henriquemoreira.clinica.services.AnamneseService;


@RestController
@RequestMapping(value = "/anamnese")
public class AnamneseController {

	@Autowired
	private AnamneseService service;

	// busca todas os dados de todas as anamneses
	@GetMapping
	public List<Anamnese> anamneses() {
		return service.allAnamnese();
	}
	
	// cria uma anamnese
	@PostMapping
	public Anamnese newAnamnese(@RequestBody Anamnese entity) {
		return service.newAnamnese(entity);
	}
	
	// edita uma anamnese
	@PutMapping("/{id}")
	public Anamnese updateAnamnese(@PathVariable Integer id, @RequestBody Anamnese entity) {
		return service.updateAnamnese(id, entity);
	}
	
	// busca os dados de uma anamnese pelo id
	@GetMapping("/{id}")
	public Anamnese findAnamnese(@PathVariable Integer id) {
		return service.findByIdAnamnese(id);
	}
	
	// deleta uma anamnese passando o id
	@DeleteMapping("/{id}")
	public void deleteAnamnese(@PathVariable Integer id) {
		service.deleteAnamnese(id);
	}
	
	// vincula uma doença a uma anamnese
	@GetMapping("/teste/{idAnamnese}/{idDoenca}")
	public void insertDoencaIntoAnamnese(@PathVariable Integer idAnamnese, @PathVariable Integer idDoenca) {
		service.insertDoencaIntoAnamnese(idAnamnese, idDoenca);
	}
}
