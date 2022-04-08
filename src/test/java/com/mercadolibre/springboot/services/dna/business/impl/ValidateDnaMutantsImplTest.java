package com.mercadolibre.springboot.services.dna.business.impl;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.model.api.request.body.Dna;
import com.mercadolibre.springboot.services.dna.util.TestUtilDna;
import com.mercadolibre.springboot.services.dna.util.constants.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class ValidateDnaMutantsImplTest {
	
	@InjectMocks
	private TestUtilDna testUtilDna;
	
	@InjectMocks
	private ValidateDnaMutantsImpl validateDnaMutantsImpl;
	
	
	@Test
	public void validateDnaMutantTest() throws IOException, ApiException {
		Dna dna = testUtilDna.getDnaRequest(TestConstants.DNA_REQUEST);
		String[] stringsDna = dna.getDna().parallelStream().toArray(String[]::new);
		
		int isMutant = validateDnaMutantsImpl.findDnaMutants(stringsDna);
		
		Assert.assertEquals(1, isMutant);
	}
	
	@Test
	public void validateDnaHumanTest() throws IOException, ApiException {
		Dna dna = testUtilDna.getDnaRequest(TestConstants.DNA_HUMAN_REQUEST);
		
		String[] stringsDna = dna.getDna().parallelStream().toArray(String[]::new);
		int isMutant = validateDnaMutantsImpl.findDnaMutants(stringsDna);
		
		Assert.assertEquals(0, isMutant);
	}
	
	@Test
	public void validateDnaWithAllConditionsTest() throws IOException, ApiException {
		Dna dna = testUtilDna.getDnaRequest(TestConstants.DNA_ALL_REQUEST);
		
		String[] stringsDna = dna.getDna().parallelStream().toArray(String[]::new);
		int isMutant = validateDnaMutantsImpl.findDnaMutants(stringsDna);
		
		Assert.assertEquals(3, isMutant);
	}
	
	


}
