package com.ionep.egis.current.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.kafka.core.KafkaTemplate;

import com.ionep.egis.current.domain.CurrentConditions;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class CurrentWeatherGeneratorTest {
	
	@Mock
	KafkaTemplate<String, CurrentConditions> kafkaTemplate;
	
	@Test
	public void constructor() throws Exception {
		String city = "BALTIMORE_MD";
		CurrentWeatherGenerator generator = new CurrentWeatherGenerator(city, kafkaTemplate);
		assertNotNull(generator);
		assertEquals(city, generator.getCity());
	}

	@Test
	public void run() throws Exception {
		String city = "BALTIMORE_MD";
		CurrentWeatherGenerator generator = new CurrentWeatherGenerator(city, kafkaTemplate);
		generator.run();
	}

}
