package com.ionep.egis.current.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.ionep.egis.current.domain.CurrentConditions;

public class CurrentWeatherGeneratorTest {
	
	@Test
	public void constructor() throws Exception {
		String city = "BALTIMORE_MD";
		KafkaTemplate<String, CurrentConditions> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		CurrentWeatherGenerator generator = new CurrentWeatherGenerator(city, kafkaTemplate);
		assertNotNull(generator);
		assertEquals(city, generator.getCity());
	}

	@Disabled
	@Test
	public void run() throws Exception {
		String city = "BALTIMORE_MD";
		KafkaTemplate<String, CurrentConditions> kafkaTemplate = new KafkaTemplate<>(producerFactory());
		CurrentWeatherGenerator generator = new CurrentWeatherGenerator(city, kafkaTemplate);
		generator.run();
	}

	public ProducerFactory<String, CurrentConditions> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

}
