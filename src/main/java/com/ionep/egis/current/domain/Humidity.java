package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Humidity {
	
	private long id;

	@NonNull
	private int humid;
	
	public Humidity() {
	}
	
	public Humidity(int humid) {
		this.humid = humid;
	}
	
	public Humidity from(Humidity humidity) {
		this.humid = humidity.humid;
		return this;
	}
	
	public int getHumid() {
		return this.humid;
	}
	
	public void setHumid(int humid) {
		this.humid = humid;
	}

}
