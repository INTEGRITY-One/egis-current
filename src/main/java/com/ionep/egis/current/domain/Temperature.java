package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Temperature {
	
	private long id;
	
	@NonNull
	private int temp;
	
	public Temperature() {
	}
	
	public Temperature(int temp) {
		this.temp = temp;
	}
	
	public Temperature from(Temperature temperature) {
		this.temp = temperature.temp;
		return this;
	}
	
	public int getTemp() {
		return this.temp;
	}
	
	public void setTemp(int temp) {
		this.temp = temp;
	}

}
