package com.mridasoft.learning.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MyBO2 extends AbstractBusinessObject implements Externalizable{

	private static final long serialVersionUID = 1L;
	
	private int creditCardNumber;
	
	public MyBO2() {
		super("MyBO2", 1);
		System.out.println("--------MyBO2------");
	}

	public int getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + creditCardNumber;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyBO2 other = (MyBO2) obj;
		if (creditCardNumber != other.creditCardNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyBO2 [creditCardNumber=" + creditCardNumber + ", code=" + code
				+ ", version=" + version + "]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		System.out.println("MyBO2::writeExternal");
		
		//194 if we uncomment below lines
		
		//out.writeObject((getCode()));
		//out.writeInt((getVersion()));
		out.writeInt((getCreditCardNumber()));
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		System.out.println("MyBO2::readExternal");
		//setCode((String) in.readObject());
		//setVersion(in.readInt());
		setCreditCardNumber(in.readInt());
	}
	
	 

}
