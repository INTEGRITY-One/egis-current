package com.ionep.egis.current.core;

import java.time.LocalDateTime;
import java.time.Month;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;

import com.ionep.egis.current.domain.City;
import com.ionep.egis.current.domain.CloudConditions;
import com.ionep.egis.current.domain.Cloudiness;
import com.ionep.egis.current.domain.CurrentConditions;
import com.ionep.egis.current.domain.DateDimension;
import com.ionep.egis.current.domain.Humidity;
import com.ionep.egis.current.domain.Precipitation;
import com.ionep.egis.current.domain.Pressure;
import com.ionep.egis.current.domain.Temperature;
import com.ionep.egis.current.domain.Wind;
import com.ionep.egis.current.domain.WindDirection;

public class CurrentWeatherGenerator implements Runnable {

	private static Log log = LogFactory.getLog(CurrentWeatherGenerator.class);
	
	private LocalDateTime localDateTime = LocalDateTime.of(2000, Month.JANUARY, 1, 0, 0);
	
	private String city;
	
	private KafkaTemplate<String, CurrentConditions> kafkaTemplate;
	
	private NewTopic topic;
	
	public CurrentWeatherGenerator(String city, KafkaTemplate<String, CurrentConditions> kafkaTemplate) {
		this.city = city;
		this.kafkaTemplate = kafkaTemplate;
		this.topic = new NewTopic(city, 1, (short)1);
	}
	
	public String getCity() {
		return this.city;
	}
	
	public NewTopic getTopic() {
		return this.topic;
	}
	
	@Override
	public void run() {
		generate();
	}
	
	protected void generate() {
		log.info("Conditions for city: " + getCity());
		log.info("-------------------- ");
		Temperature temperature = new Temperature(72);
		Precipitation precipitation = new Precipitation(2);
		Humidity humidity = new Humidity(30);
		CloudConditions cloudConditions = new CloudConditions(Cloudiness.CLEAR.ordinal());
		Wind wind = new Wind(WindDirection.EAST.ordinal(), 5);
		Pressure pressure = new Pressure(30);
		LocalDateTime localDateTime = incrementTimestamp();
		DateDimension date = new DateDimension(localDateTime);
		CurrentConditions conditions = new CurrentConditions();
		conditions.setDate(date);
		conditions.setTemperature(temperature);
		conditions.setPrecipitation(precipitation);
		conditions.setHumidity(humidity);
		conditions.setCloudConditions(cloudConditions);
		conditions.setWind(wind);
		conditions.setPressure(pressure);
		conditions.setCity(new City(this.city));
		log.info("date         : " + conditions.getDate().getDate());
		log.info("hour         : " + conditions.getDate().getHour());
		log.info("temperature  : " + conditions.getTemperature().getTemp());
		log.info("precipitation: " + conditions.getPrecipitation().getPrecip());
		log.info("humidity     : " + conditions.getHumidity().getHumid());
		log.info("cloudiness   : " + conditions.getCloudConditions().getCloudiness());
		log.info("wind         : " + conditions.getWind().getDir() + " " + conditions.getWind().getSpeed());
		log.info("pressure     : " + conditions.getPressure().getPress());
		log.info("Sending to Kafka");
		this.kafkaTemplate.send(city, conditions);
		log.info("Sent to Kafka");
	}

	protected synchronized LocalDateTime incrementTimestamp() {
		LocalDateTime timestamp = LocalDateTime.from(localDateTime);
		this.localDateTime = this.localDateTime.plusHours(1);
		return timestamp;
	}

}
