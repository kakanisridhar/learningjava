package com.mridasoft.learning.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyBusinessObject extends AbstractBusinessObject {
	private static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private int age;
	private double wealth; 
	
	public MyBusinessObject() {
		super("MyBusinessObject", 1);
		System.out.println("--------MyBusinessObject------");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void setWealth(double wealth) {
		this.wealth = wealth;
	}
	
	public double getWealth() {
		return wealth;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + age;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(wealth);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		MyBusinessObject other = (MyBusinessObject) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (Double.doubleToLongBits(wealth) != Double
				.doubleToLongBits(other.wealth))
			return false;
		return true;
	}

	@Override
	public String toString() {
		
		return "MyBusinessObject [firstName=" + firstName + ", lastName="
				+ lastName + ", age=" + age + ", wealth=" + wealth + ",code="+ code + ",version="+ version + "]";
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		System.out.println("--------MyBusinessObject::writeObject------");
		out.writeObject(firstName);
		out.writeObject(lastName);
		out.writeInt(age);
		out.writeDouble(wealth);
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		System.out.println("--------MyBusinessObject::readObject------");
		firstName =  (String) in.readObject();
		System.out.println(firstName);
		
		lastName  =  (String) in.readObject();
		System.out.println(lastName);
		
		age = in.readInt();
		System.out.println(age);
		
		wealth = in.readDouble();
		System.out.println(wealth);
	}
	
	
}
