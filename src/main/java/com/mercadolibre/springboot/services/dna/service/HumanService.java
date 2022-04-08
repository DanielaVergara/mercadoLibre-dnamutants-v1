package com.mercadolibre.springboot.services.dna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.springboot.services.dna.model.api.dao.Human;
import com.mercadolibre.springboot.services.dna.repository.HumanRepository;

@Service
public class HumanService {
	
	@Autowired
	HumanRepository humanRepository;

	public Human save(Human human) {
		return humanRepository.save(human);
	}
	
    public List<Human> getQuantityHuman() {
    	return humanRepository.findAll();
    }
}
