package com.mercadolibre.springboot.services.dna.expose.web;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.mercadolibre.springboot.services.dna.business.DnaMutants;
import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.model.api.request.body.Dna;
import com.mercadolibre.springboot.services.dna.util.TestUtilDna;
import com.mercadolibre.springboot.services.dna.util.constants.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class DnaMutantsControllerTest {

	@InjectMocks
	private TestUtilDna testUtilDna;
	
	@InjectMocks
	private  DnaMutantsController dnaMutantsController;
	
	@Mock
	private  DnaMutants dnaMutants; 
	
	@Test
	public void getIfMutantTest() throws IOException, ApiException {
		Dna dna = testUtilDna.getDnaRequest(TestConstants.DNA_REQUEST);
		String[] stringsDna = dna.getDna().parallelStream().toArray(String[]::new);
		
		when(dnaMutants.getIfMutant(stringsDna)).thenReturn(new ResponseEntity<String>("true",HttpStatus.OK));
		
		Assert.assertNotNull(dnaMutantsController.getIfMutant(dna));
		Assert.assertEquals(new ResponseEntity<String>("true",HttpStatus.OK), dnaMutantsController.getIfMutant(dna));
	}
	
	@Test
	public void getIfHumanTest() throws IOException, ApiException {
		Dna dna = testUtilDna.getDnaRequest(TestConstants.DNA_HUMAN_REQUEST);
		String[] stringsDna = dna.getDna().parallelStream().toArray(String[]::new);
		
		when(dnaMutants.getIfMutant(stringsDna))
		.thenReturn(new ResponseEntity<String>("false",HttpStatus.FORBIDDEN));
		
		Assert.assertNotNull(dnaMutantsController.getIfMutant(dna));
		Assert.assertEquals(new ResponseEntity<String>("false",
				HttpStatus.FORBIDDEN), dnaMutantsController.getIfMutant(dna));
	}
	
	@Test
	public void validateDnaTest() throws IOException, ApiException {
		Dna dna = testUtilDna.getDnaRequest(TestConstants.DNA_SEQUENCE_REQUEST);
		String[] stringsDna = dna.getDna().parallelStream().toArray(String[]::new);
		
		when(dnaMutants.getIfMutant(stringsDna))
		.thenThrow(new ApiException(400,"La base de nitrogenada del ADN tiene un formato incorrecto."));
		
		Assert.assertNotNull(dnaMutantsController.getIfMutant(dna));
		Assert.assertEquals(new ResponseEntity<String>("La base de nitrogenada del ADN tiene un formato incorrecto.",
						HttpStatus.BAD_REQUEST),
				dnaMutantsController.getIfMutant(dna));
	}
	
	@Test
	public void validateSizeDnaTest() throws IOException, ApiException {
		Dna dna = testUtilDna.getDnaRequest(TestConstants.DNA_SEQUENCE_REQUEST);
		String[] stringsDna = dna.getDna().parallelStream().toArray(String[]::new);
		
		when(dnaMutants.getIfMutant(stringsDna))
		.thenThrow(new ApiException(400,"El tamaño de todas las secuencias de ADN debe ser el mismo."));
		
		Assert.assertNotNull(dnaMutantsController.getIfMutant(dna));
		Assert.assertEquals(new ResponseEntity<String>("El tamaño de todas las secuencias de ADN debe ser el mismo.",
						HttpStatus.BAD_REQUEST),dnaMutantsController.getIfMutant(dna));
	}
}

