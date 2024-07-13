package com.mridasoft.learning.generics;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Entity<T extends Serializable> {
	
	protected LocalDateTime creationTime;
    protected LocalDateTime modificationTime;
    
    protected T id;
    
    public Object readResolve() {
        if (this.creationTime == null) {
            this.creationTime = LocalDateTime.now();
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

	public LocalDateTime getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(LocalDateTime creationTime) {
		this.creationTime = creationTime;
	}

	public LocalDateTime getModificationTime() {
		return modificationTime;
	}

	public void setModificationTime(LocalDateTime modificationTime) {
		this.modificationTime = modificationTime;
	}
    

}
