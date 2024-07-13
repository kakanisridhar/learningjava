package com.mridasoft.learning.serialization;

import java.io.Serializable;

public class AbstractBusinessObject implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String code;
	
	protected int version;
	
	public AbstractBusinessObject(String code,int ver) {
		System.out.println("--------AbstractBusinessObject------");
		this.code = code;
		this.version = ver;
	}

	public String getCode() {
		return code;
	}
	
	protected void setCode(String code) {
		this.code = code;
	}

	public int getVersion() {
		return version;
	}
	
	protected void setVersion(int version) {
		this.version = version;
	}

	@Override
	public int hashCode() {
		System.out.println("AbstractBusinessObject::hashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + version;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("AbstractBusinessObject::equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AbstractBusinessObject other = (AbstractBusinessObject) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AbstractBusinessObject [code=" + code + ", version=" + version	+ "]";
	}

}
