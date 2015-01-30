package com.mridasoft.learning.defmeths;

public class MyApp {
	public static void main(String[] args) {
		EquityMarketDataDef mdDef = new EquityMarketDataDef();
		mdDef.setInstrumentCode("RNRL");
		System.out.println(mdDef.toDebugString());
	}
}
