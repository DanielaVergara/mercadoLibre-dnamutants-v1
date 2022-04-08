package com.mercadolibre.springboot.services.dna.business.impl;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.mercadolibre.springboot.services.dna.service.HumanService;
import com.mercadolibre.springboot.services.dna.util.TestUtilDna;


@RunWith(MockitoJUnitRunner.class)
@DataJpaTest
public class StatisticsDnaImplTest {

@InjectMocks
private StatisticsDnaImpl statisticsDnaImpl;
	
@Mock
private HumanService humanService;

@InjectMocks
private TestUtilDna testUtilDna;


	@Test
	public void getStatisticsDna() throws IOException {

		Assert.assertNotNull(statisticsDnaImpl.getStatisticsDna().getRatio());
		Assert.assertNotNull(statisticsDnaImpl.getStatisticsDna().getCountHumanDna());
		Assert.assertNotNull(statisticsDnaImpl.getStatisticsDna().getCountMutantDna());
	}

}
