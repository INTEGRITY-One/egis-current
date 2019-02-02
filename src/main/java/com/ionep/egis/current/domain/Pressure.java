package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class Pressure {
	
	private long id;
	
	@NonNull
	private int press;
	
	public Pressure() {
	}
	
	public Pressure(int press) {
		this.press = press;
	}
	
	public Pressure from(Pressure pressure) {
		this.press = pressure.getPress();
		return this;
	}
	
	public int getPress() {
		return this.press;
	}
	
	public void setPress(int press) {
		this.press = press;
	}

}
