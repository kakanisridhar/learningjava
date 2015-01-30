package com.mridasoft.learning.json.domain;

import org.joda.time.DateTime;

import com.google.common.base.Objects;

public class MaturityShiftEvent implements ScenarioEvent {
	
	public static final String EVENT_TYPE = "MaturityShiftEvent"; 
	
	private String name;
	
	private String description;
	
	private DateTime period;
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public DateTime getPeriod() {
		return period;
	}
	
	public void setPeriod(DateTime period) {
		this.period = period;
	}

	@Override
	public void process() {
		
	}
	
	@Override
	public int hashCode(){
		return Objects.hashCode(name, description, period);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof MaturityShiftEvent) {
			MaturityShiftEvent that = (MaturityShiftEvent) object;
			return Objects.equal(this.name, that.getName()) &&
			       Objects.equal(this.description, that.getDescription()) &&
			       Objects.equal(this.period, that.getPeriod());
		}
		return false;
	}

	@Override
	public String toString() {
		return "MaturityShiftEvent [description=" + description + ", name=" + name + "]";
	}
	
}
