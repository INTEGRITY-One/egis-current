package com.ionep.egis.current.config;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.ProducerFactory;

import com.ionep.egis.current.domain.CurrentConditions;

public class KafkaProducerConfigTest {
	
	@Test
	public void constructor() throws Exception {
		KafkaProducerConfig producerConfig = new KafkaProducerConfig();
		assertNotNull(producerConfig);
	}
	
	@Test
	public void bootstrapAddress() throws Exception {
		String bootstrapAddess = "localhost:1234";
		KafkaProducerConfig producerConfig = new KafkaProducerConfig();
		producerConfig.setBootstrapAddress(bootstrapAddess);
		assertEquals(bootstrapAddess, producerConfig.getBootstrapAddress());
	}

	@Test
	public void producerFactory() throws Exception {
		KafkaProducerConfig producerConfig = new KafkaProducerConfig();
		ProducerFactory<String, CurrentConditions> producerFactory = producerConfig.producerFactory();
		assertNotNull(producerFactory);
	}

}
