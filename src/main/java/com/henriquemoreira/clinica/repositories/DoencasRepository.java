package com.henriquemoreira.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.clinica.entities.Doenca;

@Repository
public interface DoencasRepository extends JpaRepository<Doenca, Integer> {

}
