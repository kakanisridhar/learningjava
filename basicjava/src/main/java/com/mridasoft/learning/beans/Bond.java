package com.mridasoft.learning.beans;

public class Bond {
	
	String security;
	int issueDate;
	
	public Bond() {
	
	}

	public String getSecurity() {
		return security;
	}

	public void setSecurity(String security) {
		this.security = security;
	}

	public int getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(int issueDate) {
		this.issueDate = issueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + issueDate;
		result = prime * result
				+ ((security == null) ? 0 : security.hashCode());
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
		if (security == null) {
			if (other.security != null)
				return false;
		} else if (!security.equals(other.security))
			return false;
		return true;
	}
	
	
	
}
