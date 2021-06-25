package com.henriquemoreira.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.clinica.entities.Anamnese;

@Repository
public interface AnamneseRepository extends JpaRepository<Anamnese, Integer> {
}
