package com.mercadolibre.springboot.services.dna.business.impl;

import org.springframework.stereotype.Service;

import com.mercadolibre.springboot.services.dna.business.ValidateDnaMutants;
import com.mercadolibre.springboot.services.dna.exception.ApiException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ValidateDnaMutantsImpl implements ValidateDnaMutants{
	
	public int findDnaMutants(String[] dna) throws ApiException  {
		int isMutant = 0;
			for (int i = 0; i < dna.length; i++) {
				    for (int j = 0; j < dna[i].length(); j++) {
				    	isMutant = checkIfExistsRow(dna, i, j, isMutant);
				    	isMutant = checkIfExistsColumns(dna, i, j, isMutant);
				    	isMutant = checkIfExistsDiagonal(dna, i, j, isMutant);
				    }
			}
		return isMutant;
	}
		
		private static int checkIfExistsRow(String[] dna, int i, int j, int isMutant) {
		  if(j < dna[i].length()-3) {
			  if (dna[i].charAt(j) == dna[i].charAt(j+1)
					    && dna[i].charAt(j) == dna[i].charAt(j+2)
					    && dna[i].charAt(j) == dna[i].charAt(j+3))
			  	{
				  isMutant++;
			    }
		  }
			
			return isMutant;
		}
		
		private static int checkIfExistsColumns(String[] dna, int i, int j, int isMutant) {
		  if(i < dna.length-3) {
			if (dna[i].charAt(j) == dna[i+1].charAt(j)
			    && dna[i].charAt(j) ==  dna[i+2].charAt(j)
			    && dna[i].charAt(j)  == dna[i+3].charAt(j))
			    {
				 	isMutant++;
			    }
		  	} 
			return isMutant;
		}
		
		private static int checkIfExistsDiagonal(String[] dna, int i, int j, int isMutant) {
		  if(i < dna.length-3 && j < dna[i].length()-3) {
			if (dna[i].charAt(j) == dna[i+1].charAt(j+1)
			    && dna[i].charAt(j) == dna[i+2].charAt(j+2)
			    && dna[i].charAt(j) ==  dna[i+3].charAt(j+3))
			    {
			        isMutant++;
			    }
		  }
			return isMutant;
		}
		
}
