package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseBody;

import com.henriquemoreira.clinica.entities.Anamnese;
import com.henriquemoreira.clinica.entities.Doenca;
import com.henriquemoreira.clinica.repositories.AnamneseRepository;
import com.henriquemoreira.clinica.repositories.DoencasRepository;
import com.henriquemoreira.clinica.services.exceptions.AnamneseNotFoundException;

@Service
public class AnamneseService {

	@Autowired
	private AnamneseRepository repository;
	
	@Autowired
	private DoencasRepository doencasRepository;

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
	
	@SuppressWarnings("null")
	@ResponseBody
    @Transactional
	public void insertDoencaIntoAnamnese(Integer idAnamnese, Integer idDoenca) {
		Anamnese anamneseAtual = repository.getById(idAnamnese);
		Doenca doencaAtual = doencasRepository.getById(idDoenca);
		List<Doenca> doencas = null;
		doencas.add(doencasRepository.getById(idDoenca));
		
		anamneseAtual.setDoencas(doencas);
	}
}
