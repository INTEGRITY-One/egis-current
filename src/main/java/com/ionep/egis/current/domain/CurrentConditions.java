package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class CurrentConditions {
	
	private long id;
	
	@NonNull
	private Temperature temperature;

	@NonNull
	private Precipitation precipitation;
	
	@NonNull
	private Humidity humidity;
	
	@NonNull
	private CloudConditions cloudConditions;
	
	@NonNull
	private Wind wind;
	
	@NonNull
	private Pressure pressure;
	
	@NonNull
	private City city;
	
	@NonNull
	private DateDimension date;
	
	public CurrentConditions() {
	}
	
	public CurrentConditions from(CurrentConditions currentConditions) {
		this.city = currentConditions.city;
		this.cloudConditions = currentConditions.cloudConditions;
		this.date = currentConditions.date;
		this.humidity = currentConditions.humidity;
		this.precipitation = currentConditions.precipitation;
		this.pressure = currentConditions.pressure;
		this.temperature = currentConditions.temperature;
		this.wind = currentConditions.wind;
		return this;
	}

	public Temperature getTemperature() {
		return this.temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public Precipitation getPrecipitation() {
		return this.precipitation;
	}

	public void setPrecipitation(Precipitation precipitation) {
		this.precipitation = precipitation;
	}

	public Humidity getHumidity() {
		return this.humidity;
	}

	public void setHumidity(Humidity humidity) {
		this.humidity = humidity;
	}

	public CloudConditions getCloudConditions() {
		return this.cloudConditions;
	}
	
	public void setCloudConditions(CloudConditions cloudConditions) {
		this.cloudConditions = cloudConditions;
	}

	public Wind getWind() {
		return this.wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Pressure getPressure() {
		return this.pressure;
	}

	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public DateDimension getDate() {
		return this.date;
	}

	public void setDate(DateDimension date) {
		this.date = date;
	}

}
