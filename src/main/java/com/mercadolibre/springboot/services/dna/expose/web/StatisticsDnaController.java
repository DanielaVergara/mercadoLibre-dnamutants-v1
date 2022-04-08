package com.mercadolibre.springboot.services.dna.expose.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.springboot.services.dna.business.StatisticsDna;
import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.model.api.response.Statistics;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;

@RequestMapping
@RestController
@AllArgsConstructor
public class StatisticsDnaController {

	private final StatisticsDna statisticsDna;
	
	@Operation(tags= "Statistics v1",
			summary= "DNA verification statistics.",
			method="GET",
			responses = {
					@ApiResponse(
							responseCode= "200",
							description= "El proceso se ha ejecutado correctamente.",
							content= @Content(schema= @Schema(implementation = ResponseEntity.class))),
					@ApiResponse(
							responseCode= "500",
							description= "Ocurrio un error en el sistema.",
							content= @Content(schema= @Schema(implementation = ResponseEntity.class))),
					@ApiResponse(
							responseCode= "401",
							description= "No se encontro la información solicitada.",
							content= @Content(schema= @Schema(implementation = ResponseEntity.class)))
			})
	@GetMapping(value="/stats/", 
	produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.OK)
	public Statistics getStatisticsDna() throws ApiException{
		return statisticsDna.getStatisticsDna();
	}
}
