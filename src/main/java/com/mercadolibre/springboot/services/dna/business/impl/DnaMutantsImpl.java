package com.mercadolibre.springboot.services.dna.business.impl;


import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mercadolibre.springboot.services.dna.business.DnaMutants;
import com.mercadolibre.springboot.services.dna.business.ValidateDnaMutants;
import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.model.api.dao.Human;
import com.mercadolibre.springboot.services.dna.service.HumanService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DnaMutantsImpl implements DnaMutants {
	
	@Autowired 
	HumanService humanService;
	
	private final ValidateDnaMutants validateDnaMutants;

	public ResponseEntity<String> getIfMutant(String[] dnaMutants) throws ApiException {
		int isMutant = 0;
		try {
			if(validateSizeDnaSequence(dnaMutants) && validateNitrogenousBase(dnaMutants)) {
				 isMutant = validateDnaMutants.findDnaMutants(dnaMutants);
			}
		} catch (ApiException e) {
			log.error(e.getMessage());
	        throw new ApiException(e.getCodeStatus(),e.getMessage());
		}
		return valideIfItIsMutant(isMutant, dnaMutants);
	}
	
	private ResponseEntity<String> valideIfItIsMutant(int isMutant,String[] dnaMutants) throws ApiException {
		if(isMutant>0) {
			setHuman(dnaMutants,1);
			 return new ResponseEntity<String>("true",HttpStatus.OK);
		}else {
			 setHuman(dnaMutants,2);
			 return new ResponseEntity<String>("false",HttpStatus.FORBIDDEN);
		}
	}

	private void setHuman(String[] dnaMutants, int kindHuman) {
		String dna = String.join("", dnaMutants).toUpperCase();
		Human human = new Human(dna,kindHuman);
		humanService.save(human);
	}
	
	private boolean validateSizeDnaSequence(String[] dna) throws ApiException {
		 int sizeDnaSequence = dna.length;
		 for (String dnaSequence : dna) {
			if(dnaSequence.length() != sizeDnaSequence) {
				throw new ApiException(400,"El tamaño de todas las secuencias de ADN debe ser el mismo.");
			}
		}
		 return true;
	}
	
	private boolean validateNitrogenousBase(String[] dna) throws ApiException {
		Pattern pattern = Pattern.compile("[acgt]+", Pattern.CASE_INSENSITIVE);
		 for (String dnaSequence : dna) {
				if(!pattern.matcher(dnaSequence).matches()) {
					throw new ApiException(400,"La base de nitrogenada del ADN tiene un formato incorrecto.");
				}
			}
		 return true;
	}	

}
