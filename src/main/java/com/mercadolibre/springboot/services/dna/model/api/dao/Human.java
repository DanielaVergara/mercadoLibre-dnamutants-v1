package com.mercadolibre.springboot.services.dna.model.api.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Human {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Schema(title="dna",
			description="Represents all dna",
			type = "String",
			required = true, example = "ATGCGACAGTGCTTATGTAGAAGGCCCCTATCACTG")
	private String dna;
	
	@Schema(title="dna",
			description="Represents if it's a human or mutant. 1=mutant 2=human",
			type = "int",
			required = true, example = "1")
	private int kindHuman;
	
	public Human(String dna, int kindHuman) {
		this.dna = dna;
		this.kindHuman = kindHuman;
	}
	
}
