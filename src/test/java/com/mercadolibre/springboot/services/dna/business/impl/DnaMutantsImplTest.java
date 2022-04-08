package com.mercadolibre.springboot.services.dna.business.impl;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mercadolibre.springboot.services.dna.business.ValidateDnaMutants;
import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.repository.HumanRepository;
import com.mercadolibre.springboot.services.dna.util.TestUtilDna;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class DnaMutantsImplTest {

	@Mock
	private ValidateDnaMutants validateDnaMutants;
		
	@Mock
	private HumanRepository humanRepository;
	
	@InjectMocks
	private DnaMutantsImpl dnaMutantsImpl;

	@InjectMocks
	private TestUtilDna testUtilDna;
	
	
	@Test
	public void getIfMutantTest() throws ApiException, IOException {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
		when(validateDnaMutants.findDnaMutants(dna)).thenReturn(3);
		
		Assert.assertEquals(new ResponseEntity<String>("true",HttpStatus.OK), dnaMutantsImpl.getIfMutant(dna));
	}
	
	@Test
	public void getIfHumanTest() throws ApiException, IOException {
		String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCTTA","TCACTG"};
		when(validateDnaMutants.findDnaMutants(dna)).thenReturn(0);
		
		Assert.assertEquals(new ResponseEntity<String>("false",HttpStatus.FORBIDDEN),
				dnaMutantsImpl.getIfMutant(dna));
	}
	
	@Test
	public void validateSizeDnaSequenceTest() throws ApiException, IOException {
		ApiException apiException = new ApiException();
		try {
			String[] dna = {"ATGCGA","CAGTGCD","TTATGT","AGAAGG","CCCTTA","TCACTG"};
			dnaMutantsImpl.getIfMutant(dna);
		} catch (ApiException e) {
			apiException = e;
		}
		Assert.assertEquals(apiException.getMessage(), "El tamaño de todas las secuencias de ADN debe ser el mismo.");
	}
	
	@Test
	public void validateNitrogenousBaseTest() throws ApiException, IOException {
		ApiException apiException = new ApiException();
		try {
			String[] dna = {"ATGCGA","CHGTGC","TTATGT","AGAAGG","CCCTTA","TCACTG"};
			dnaMutantsImpl.getIfMutant(dna);
		} catch (ApiException e) {
			apiException = e;
		}
		Assert.assertEquals(apiException.getMessage(), "La base de nitrogenada del ADN tiene un formato incorrecto.");
	}
	
	
}
