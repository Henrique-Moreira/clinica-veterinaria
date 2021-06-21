package com.henriquemoreira.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.clinica.entities.Exame;

@Repository
public interface ExameRepository extends JpaRepository<Exame, Integer> {

}
