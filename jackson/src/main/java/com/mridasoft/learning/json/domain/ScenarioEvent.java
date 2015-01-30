package com.mridasoft.learning.json.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;


@JsonTypeInfo(  
	    use = JsonTypeInfo.Id.MINIMAL_CLASS,  
	    include = JsonTypeInfo.As.PROPERTY,  
	    property = "type")
public interface ScenarioEvent {

	void process();
	
}
