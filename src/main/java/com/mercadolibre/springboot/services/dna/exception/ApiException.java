package com.mercadolibre.springboot.services.dna.exception;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@NoArgsConstructor
public class ApiException extends Exception {

	@Schema(title="codeStatus",
			description="Code http of the response",
			type = "String",
			required = true)
	protected int codeStatus;
	
	@Schema(title="message",
			description="mesage http of the response",
			type = "String",
			required = true)
	protected String message;
	
	  public ApiException(int codeStatus, String message) {
	        this.codeStatus = codeStatus;
	        this.message = message;
	  } 
	  
	  
    @Override
    public String getMessage() {
        return message;
    }

    public int getCodeStatus() {
        return codeStatus;
    }

}
