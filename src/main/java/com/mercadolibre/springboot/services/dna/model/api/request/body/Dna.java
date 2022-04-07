package com.mercadolibre.springboot.services.dna.model.api.request.body;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
@JsonIgnoreProperties
@Schema(description= "Send if a human is a mutant based on their DNA sequence.")
public class Dna {

	
	@Schema(title="dna",
			description="Represents each row of DNA",
			type = "List",
			required = true)
	@Valid
	@NotNull
	@NotEmpty
	@JsonProperty("dna")
	private List<String> dna;
	
	


}
