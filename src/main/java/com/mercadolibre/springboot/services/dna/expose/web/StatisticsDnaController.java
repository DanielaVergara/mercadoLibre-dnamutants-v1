package com.mercadolibre.springboot.services.dna.expose.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.springboot.services.dna.business.StatisticsDna;
import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.model.api.response.Statistics;

import lombok.AllArgsConstructor;

@RequestMapping
@RestController
@AllArgsConstructor
public class StatisticsDnaController {

	private final StatisticsDna statisticsDna;
	
	@GetMapping(value="/stats/", 
	produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Statistics getStatisticsDna() throws ApiException{
		return statisticsDna.getStatisticsDna();
	}
}
