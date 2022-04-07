package com.mercadolibre.springboot.services.dna.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mercadolibre.springboot.services.dna.model.api.dao.Human;

@Repository
public interface HumanRepository extends JpaRepository<Human,Integer> {

}
