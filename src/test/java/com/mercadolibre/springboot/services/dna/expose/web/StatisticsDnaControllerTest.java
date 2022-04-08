package com.mercadolibre.springboot.services.dna.expose.web;

import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mercadolibre.springboot.services.dna.business.StatisticsDna;
import com.mercadolibre.springboot.services.dna.exception.ApiException;
import com.mercadolibre.springboot.services.dna.model.api.response.Statistics;
import com.mercadolibre.springboot.services.dna.util.TestUtilDna;
import com.mercadolibre.springboot.services.dna.util.constants.TestConstants;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsDnaControllerTest {
	
	@Mock
	private StatisticsDna statisticsDna;
	
	@InjectMocks
	private StatisticsDnaController staDnaController;
	
	@InjectMocks
	private TestUtilDna testUtilDna;
	
	@Test
	public void getStatisticsDnaTest() throws IOException, ApiException {
		Statistics st = testUtilDna.getStatistics(TestConstants.STATISTICS_RESPONSE);
		when(statisticsDna.getStatisticsDna()).thenReturn(st);
		Assert.assertEquals(st, staDnaController.getStatisticsDna());
	}

}
