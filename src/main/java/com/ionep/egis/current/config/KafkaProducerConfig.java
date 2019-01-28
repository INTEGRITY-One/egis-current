package com.ionep.egis.current.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.ionep.egis.current.domain.CurrentConditions;

@Configuration
public class KafkaProducerConfig {
	
	@Value(value = "${kafka.bootstrapAddress}")
	private String bootstrapAddress;

	public String getBootstrapAddress() {
		return this.bootstrapAddress;
	}

	public void setBootstrapAddress(String bootstrapAddress) {
		this.bootstrapAddress = bootstrapAddress;
	}

	@Bean
	public ProducerFactory<String, CurrentConditions> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, this.bootstrapAddress);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}

	@Bean
	public KafkaTemplate<String, CurrentConditions> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
