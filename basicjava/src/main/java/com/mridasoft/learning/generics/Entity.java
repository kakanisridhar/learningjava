package com.mridasoft.learning.generics;

import java.io.Serializable;

import org.joda.time.DateTime;

public class Entity<T extends Serializable> {
	
	protected DateTime creationTime;
    protected DateTime modificationTime;
    
    protected T id;
    
    public Object readResolve() {
        if (this.creationTime == null) {
            this.creationTime = new DateTime();
            this.modificationTime = creationTime;
        }

        return this;
    }

    public T getId() {
        return id;
    }


    public void setId(T id) {
        this.id = id;
    }

	public DateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(DateTime creationTime) {
		this.creationTime = creationTime;
	}

	public DateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(DateTime modificationTime) {
		this.modificationTime = modificationTime;
	}
    

}
