package com.mridasoft.learning.ds.trees.impl1;

public class StringTreeNodeId implements TreeNodeId<String> {

	private String id;
	
	public StringTreeNodeId(String key) {
		this.id = key;
	}
	
	@Override
	public String getKey() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		StringTreeNodeId other = (StringTreeNodeId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StringTreeNodeId [" + id + "]";
	}
	
}
