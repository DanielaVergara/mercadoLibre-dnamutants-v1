package com.mercadolibre.springboot.services.dna.util;

import java.io.IOException;

import org.apache.commons.io.IOUtils;
import com.google.gson.Gson;
import com.mercadolibre.springboot.services.dna.model.api.dao.Human;
import com.mercadolibre.springboot.services.dna.model.api.request.body.Dna;
import com.mercadolibre.springboot.services.dna.model.api.response.Statistics;

public class TestUtilDna {

	ClassLoader classLoader = getClass().getClassLoader();
	Gson gson = new Gson();
	
	public Dna getDnaRequest(String jsonDna) throws IOException {
		Dna  dna= new Dna();
		String request =  IOUtils.toString(classLoader.getResourceAsStream(jsonDna), "UTF-8");
		dna = gson.fromJson(request, Dna.class);
		return dna;
	}
	
	public Statistics getStatistics(String jsonDna) throws IOException {
		Statistics  st = new Statistics();
		String request =  IOUtils.toString(classLoader.getResourceAsStream(jsonDna), "UTF-8");
		st = gson.fromJson(request, Statistics.class);
		return st;
	}
	
	public Human getHuman(String jsonDna) throws IOException {
		Human  human = new Human();
		String request =  IOUtils.toString(classLoader.getResourceAsStream(jsonDna), "UTF-8");
		human = gson.fromJson(request, Human.class);
		return human;
	}

}
