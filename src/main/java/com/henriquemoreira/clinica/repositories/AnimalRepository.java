package com.henriquemoreira.clinica.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.henriquemoreira.clinica.entities.Animal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {

}
