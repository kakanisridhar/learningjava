package com.mridasoft.learning.json.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

public class ScenarioDef implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String id;
	
	private LocalDateTime valuationDate;
	
	private Period maturityPeriod;
	
	private Set<ScenarioEvent> events;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public LocalDateTime getValuationDate() {
		return valuationDate;
	}

	public void setValuationDate(LocalDateTime valuationDate) {
		this.valuationDate = valuationDate;
	}

	public Period getMaturityPeriod() {
		return maturityPeriod;
	}

	public void setMaturityPeriod(Period maturityPeriod) {
		this.maturityPeriod = maturityPeriod;
	}
	
	public Set<ScenarioEvent> getEvents() {
		
		if(events==null) {
			events = new HashSet<>();
		}
		
		return events;
	}

	public void setEvents(Set<ScenarioEvent> events) {
		this.events = events;
	}
	
	public void addEvent(ScenarioEvent event) {
		this.getEvents().add(event);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((maturityPeriod == null) ? 0 : maturityPeriod.hashCode());
		result = prime * result
				+ ((valuationDate == null) ? 0 : valuationDate.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ScenarioDef other = (ScenarioDef) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maturityPeriod == null) {
			if (other.getMaturityPeriod() != null)
				return false;
		} else if (!maturityPeriod.equals(other.getMaturityPeriod()))
			return false;
		if (valuationDate == null) {
			if (other.getValuationDate() != null)
				return false;
		} else if (!valuationDate.equals(other.getValuationDate()))
			return false;
		return true;
	}
	
	
   
}
