package com.henriquemoreira.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.henriquemoreira.clinica.entities.Anamnese;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Integer> {

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO 'anamnese_doenca' ('anamnese_id', 'doenca_id') VALUES (:idAnamnese, :idDoenca);", nativeQuery = true)
	void insertDoencaIntoAnamnese(Integer idAnamnese, Integer idDoenca);
}
