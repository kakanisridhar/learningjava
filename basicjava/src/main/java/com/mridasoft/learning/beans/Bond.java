package com.mridasoft.learning.beans;

public class Bond  extends AbstractSecurity {	
	
	int issueDate;
	
	public Bond(int f) {
		issueDate = f;
	}
	
	public int getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(int issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public double loanAmount() {
		
		return 2;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return "Bond";
	}
	
	
	protected String getName(String a) {
		// TODO Auto-generated method stub
		return a+"Bond";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + issueDate;
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
		Bond other = (Bond) obj;
		if (issueDate != other.issueDate)
			return false;
		return true;
	}
	
}
