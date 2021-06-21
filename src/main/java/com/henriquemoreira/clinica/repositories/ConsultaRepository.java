package com.henriquemoreira.clinica.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.clinica.entities.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {

}
