package com.mercadolibre.springboot.services.dna.business;

import org.springframework.http.ResponseEntity;

import com.mercadolibre.springboot.services.dna.exception.ApiException;

public interface DnaMutants {

	ResponseEntity<String> getIfMutant(String[] dnaMutants) throws ApiException;
}
