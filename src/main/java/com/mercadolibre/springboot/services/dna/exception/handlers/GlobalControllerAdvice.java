package com.mercadolibre.springboot.services.dna.exception.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.mercadolibre.springboot.services.dna.exception.ApiException;

@ControllerAdvice
@ResponseBody
public class GlobalControllerAdvice {

	
    private static final Logger logger = LoggerFactory.getLogger(GlobalControllerAdvice.class);
    
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public ApiException handleHttpMessageNotReadableException(
        MissingServletRequestParameterException ex) {
             logger.error ("Falta el parámetro de solicitud, {}", ex.getMessage ());
             return new ApiException(400, "Faltan parámetros de solicitud requeridos");
    }
}
