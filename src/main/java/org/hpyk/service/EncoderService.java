package org.hpyk.service;

import java.security.SecureRandom;

public interface EncoderService<T> {
	static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    static final int LENGTH = 10;
    static final SecureRandom RANDOM = new SecureRandom();
    
	
	 Object encode(Object message);

}
