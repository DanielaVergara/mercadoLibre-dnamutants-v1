package com.mercadolibre.springboot.services.dna.business.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.springboot.services.dna.business.StatisticsDna;
import com.mercadolibre.springboot.services.dna.model.api.dao.Human;
import com.mercadolibre.springboot.services.dna.model.api.response.Statistics;
import com.mercadolibre.springboot.services.dna.service.HumanService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StatisticsDnaImpl implements StatisticsDna {
	
	@Autowired
	HumanService humanService;

	public Statistics getStatisticsDna() {
		List<Human>  humans = humanService.getQuantityHuman();
		Integer countMutant = humans.stream().filter(p -> p.getKindHuman()==1).collect(Collectors.toList()).size();
		Integer countHuman =  humans.stream().filter(p -> p.getKindHuman()==2).collect(Collectors.toList()).size();
		Statistics statics = new Statistics(countMutant, countHuman);
		return statics;
	}
	

}
