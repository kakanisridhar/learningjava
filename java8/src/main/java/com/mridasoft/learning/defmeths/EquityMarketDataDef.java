package com.mridasoft.learning.defmeths;

public class EquityMarketDataDef implements IMarketDataDef {

	private String dataType = "EOD";
	private String source = "Sreedhara";
	private String instrumentCode;
	
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	@Override
	public String getDataType() {
		return dataType;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Override
	public String getSource() {
		return source;
	}

	@Override
	public String getInstrumentCode() {
		return instrumentCode;
	}

	public void setInstrumentCode(String instrumentCode) {
		this.instrumentCode = instrumentCode;
	}
	
}
