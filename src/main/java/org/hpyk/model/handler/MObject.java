package org.hpyk.model.handler;

public interface MObject<T> {
	T getObjectForEncoding(String email);
	T getObjectForDecoding(String email); 
	
	
}
