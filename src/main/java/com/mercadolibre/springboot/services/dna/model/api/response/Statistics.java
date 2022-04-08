package com.mercadolibre.springboot.services.dna.model.api.response;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
@NoArgsConstructor
@Schema(description= "Response statistics of the ADN's verifications.")
public class Statistics {
	
	@Schema(title="count_mutant_dna",
			description="Quantity of mutant.",
			type = "number",
			required = true)
	@JsonProperty("count_mutant_dna")
    private BigDecimal countMutantDna;
	

	@Schema(title="count_human_dna",
			description="Quantity of human.",
			type = "number",
			required = true)
	@JsonProperty("count_human_dna")
    private BigDecimal countHumanDna;
	
	@Schema(title="ratio",
			description="Quotient of quantity of humans and quantity of mutants.",
			type = "number",
			required = true)
	@JsonProperty("ratio")
    private BigDecimal ratio;
	
	public Statistics(Integer countMutant, Integer countHuman) {
		this.countMutantDna = new BigDecimal(countMutant);
        this.countHumanDna = new BigDecimal(countHuman);
        this.ratio = countHuman != 0 ?  countMutantDna.divide(countHumanDna, 2, RoundingMode.HALF_EVEN): new BigDecimal(0.00);
	}

}
