package com.mridasoft.learning.generics;

public class OrderedPair<K, V> implements Pair<K, V>{
	
	private K key;
	private V value;
	
	public OrderedPair() {
		
	}
	
	public OrderedPair(K key,V value) {
		this.key  = key;
		this.value = value;
	}
	
	/**
	 * static helper method, this is not part of generic class
	 * hence it is a generic method totally unrelated to generic class 
	 */
	public static<K, V> OrderedPair<K, V> of(K key,V value) {
		return new OrderedPair<>(key,value);
	}
	
	

    public K getKey()	{ return key; }
	public V getValue() { return value; }

	public void setKey(K key) {	this.key = key;}
	public void setValue(V value) {	this.value = value;	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		
		OrderedPair<?,?> other = (OrderedPair<?,?>) obj;
		
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}
	
	

}
