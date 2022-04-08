package com.mercadolibre.springboot.services.dna.expose.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.springboot.services.dna.business.DnaMutants;
import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.model.api.request.body.Dna;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@RequestMapping
@RestController
@AllArgsConstructor
public class DnaMutantsController {
	
	@Autowired
	private DnaMutants dnaMutants;
	
	@Operation(tags= "Dna Mutants v1",
			summary= "Detect if a human is a mutant based on their DNA sequence.",
			method="POST",
			responses = {
					@ApiResponse(
							responseCode= "200",
							description= "El proceso se ha ejecutado correctamente.",
							content= @Content(schema= @Schema(implementation = ResponseEntity.class))),
					@ApiResponse(
							responseCode= "500",
							description= "Ocurrio un error en el sistema. Contactese con el administración.",
							content= @Content(schema= @Schema(implementation = ResponseEntity.class))),
					@ApiResponse(
							responseCode= "401",
							description= "No se encontro la información solicitada.",
							content= @Content(schema= @Schema(implementation = ResponseEntity.class)))
			})
	@PostMapping(value="/mutant/", 
	produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> getIfMutant(@Valid @RequestBody @ParameterObject Dna dna) throws ApiException{
		try {
			String[] strings = dna.getDna().parallelStream().toArray(String[]::new);
			return dnaMutants.getIfMutant(strings);
		} catch (ApiException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.valueOf(e.getCodeStatus()));
		}
		
	}
}
