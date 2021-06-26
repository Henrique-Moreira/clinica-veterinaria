package com.henriquemoreira.clinica.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.henriquemoreira.clinica.entities.Anamnese;
import com.henriquemoreira.clinica.entities.Doenca;
import com.henriquemoreira.clinica.repositories.AnamneseRepository;
import com.henriquemoreira.clinica.repositories.DoencasRepository;
import com.henriquemoreira.clinica.services.exceptions.AnamneseNotFoundException;
import com.henriquemoreira.clinica.services.exceptions.DoencaExceptionOfLimitInserted;
import com.henriquemoreira.clinica.services.exceptions.DoencaNotFoundException;

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
	
	public Anamnese insertDoencaIntoAnamnese(Integer idAnamnese, Integer idDoenca) {
		Anamnese anamneseAtual = repository.findById(idAnamnese).
				orElseThrow(() -> new AnamneseNotFoundException(idAnamnese));

		Doenca doencaAtual = doencasRepository.findById(idDoenca).
				orElseThrow(() -> new DoencaNotFoundException(idDoenca));

		if(anamneseAtual.getDoencas().size() > 5) 
			throw new DoencaExceptionOfLimitInserted();
		
		anamneseAtual.getDoencas().add(doencaAtual);			
		
		return updateAnamnese(idAnamnese, anamneseAtual);
	}
}
