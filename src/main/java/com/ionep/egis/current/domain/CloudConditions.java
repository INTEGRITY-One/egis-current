package com.ionep.egis.current.domain;

import lombok.Data;
import lombok.NonNull;

@Data
public class CloudConditions {
	
	private long id;
	
	@NonNull
	int cloudiness;

	public CloudConditions() {
	}
	
	public CloudConditions(int cloudiness) {
		this.cloudiness = cloudiness;
	}
	
	public CloudConditions from(CloudConditions cloudConditions) {
		this.cloudiness = cloudConditions.cloudiness;
		return this;
	}
	
	public int getCloudiness() {
		return this.cloudiness;
	}

	public void setCloudiness(int cloudiness) {
		this.cloudiness = cloudiness;
	}

}
