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

import com.henriquemoreira.clinica.entities.Consulta;
import com.henriquemoreira.clinica.services.ConsultaService;


@RestController
@RequestMapping(value = "/consulta")
public class ConsultaController {

	@Autowired
	private ConsultaService service;

	// busca todas os dados de todas as consultas
	@GetMapping
	public List<Consulta> animals() {
		return service.allConsultas();
	}
	
	// cria uma nova consulta
	@PostMapping
	public ResponseEntity<String> newConsulta(@Valid @RequestBody Consulta entity) {
		service.newConsulta(entity);
		return ResponseEntity.ok("Consulta cadastrada com sucesso.");
	}
	
	// edita os dados de uma consulta pelo id
	@PutMapping("/{id}")
	public Consulta updateConsulta(@PathVariable Integer id, @RequestBody Consulta entity) {
		return service.updateConsultaById(id, entity);
	}
	
	// busca os dados de uma consulta pelo id
	@GetMapping("/{id}")
	public Consulta findConsultaById(@PathVariable Integer id) {
		return service.findConsultaById(id);
	}
	
	// deleta os dados de uma consulta pelo id
	@DeleteMapping("/{id}")
	public void deleteConsultaById(@PathVariable Integer id) {
		service.deleteConsultaById(id);
	}
	
}

