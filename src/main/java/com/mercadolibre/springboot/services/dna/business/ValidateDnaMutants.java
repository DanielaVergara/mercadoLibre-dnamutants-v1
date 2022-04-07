package com.mercadolibre.springboot.services.dna.business;

import com.mercadolibre.springboot.services.dna.exception.ApiException;

public interface ValidateDnaMutants {

	int findDnaMutants(String[] dna) throws ApiException;
}
