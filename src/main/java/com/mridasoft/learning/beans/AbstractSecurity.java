package com.mridasoft.learning.beans;

public abstract class AbstractSecurity implements ILaonAmountProvider{

	private String security;
	
	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	
	protected void lookup() {
		
	}
	
	protected String getName() {
		return "AbstractSecurity:";
	}
	
	
}
