package com.henriquemoreira.clinica.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.clinica.entities.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {

	@Query(value = "SELECT * FROM exame obj WHERE obj.animal_id = :idAnimal ORDER BY obj.data", nativeQuery = true)
	List<Exame> searchExamsByIdAnimal(Integer idAnimal);
}
