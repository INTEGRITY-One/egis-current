package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Precipitation {
	
	private long id;
	
	@NonNull
	private int precip;
	
	public Precipitation() {
	}
	
	public Precipitation(int precip) {
		this.precip = precip;
	}
	
	public Precipitation from(Precipitation precipitation) {
		this.precip = precipitation.precip;
		return this;
	}

	public void setPrecip(int precip) {
		this.precip = precip;
	}
	
	public int getPrecip() {
		return this.precip;
	}

}
