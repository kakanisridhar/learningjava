package com.mridasoft.learning.defmeths;

public interface IMarketDataDef {

	String getDataType();
	
	String getSource();
	
	String getInstrumentCode();
	
	default String toDebugString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getInstrumentCode()).append(":").
		append(getDataType()).append(":").append(getSource());
		return sb.toString();
	}

}
