package com.mridasoft.learning.json.domain;

import com.google.common.base.Objects;

public class MarketRiskEvent implements ScenarioEvent {
	
	public static final String EVENT_TYPE = "MarketRiskEvent";
	
	
	private String name;
	
	private String description;
	
	private String attrib1;
	
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

	public String getAttrib1() {
		return attrib1;
	}

	public void setAttrib1(String attrib1) {
		this.attrib1 = attrib1;
	}

	@Override
	public int hashCode(){
		return Objects.hashCode(name, description, attrib1);
	}
	
	@Override
	public boolean equals(Object object){
		if (object instanceof MarketRiskEvent) {
			MarketRiskEvent that = (MarketRiskEvent) object;
			return Objects.equal(this.name, that.getName()) &&
			       Objects.equal(this.description, that.getDescription()) &&
			       Objects.equal(this.attrib1, that.getAttrib1());
		}
		return false;
	}

	@Override
	public String toString() {
		return "MarketRiskEvent [description=" + description + ", name=" + name + "]";
	}

	@Override
	public void process() {
		// TODO Auto-generated method stub
		
	}
	
}
