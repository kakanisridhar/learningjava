package com.mridasoft.learning.json.jackson;

import java.io.IOException;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.joda.time.Period;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.mridasoft.learning.json.domain.MaturityShiftEvent;
import com.mridasoft.learning.json.domain.ScenarioDef;

public class JacksonObjectMapper {

	public static void main(String[] args) throws IOException {
		
		ScenarioDef scdef = new ScenarioDef();
		scdef.setId("p1");
		scdef.setMaturityPeriod(Period.years(3));
		scdef.setValuationDate(LocalDateTime.now());

		MaturityShiftEvent mshev = new MaturityShiftEvent();
		mshev.setName("mshev1");
		mshev.setDescription("mshev1");
		mshev.setPeriod(DateTime.now().plusYears(5));
		
		scdef.getEvents().add(mshev);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JodaModule());
		
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		
		String jsonString = mapper.writeValueAsString(scdef);
		
		System.out.println(jsonString);
		
		
		ScenarioDef other = mapper.readValue(jsonString, ScenarioDef.class);
		
		System.out.println(scdef.equals(other));
		
	}
	
}
