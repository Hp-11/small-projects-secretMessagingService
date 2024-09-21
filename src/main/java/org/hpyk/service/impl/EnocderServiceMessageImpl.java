package org.hpyk.service.impl;

import java.util.Base64;

import org.hpyk.model.Email;
import org.hpyk.model.Message;
import org.hpyk.model.handler.impl.UnifiedHandler;
import org.hpyk.service.EncoderService;

import org.hpyk.service.helper.DateFactory;

public class EnocderServiceMessageImpl implements EncoderService<Message>{
	public static String key = "";
	
	public EnocderServiceMessageImpl() {}
	
	private static String getKey() {
        if (key.isEmpty() || key.isBlank()) {
            key = generateRandomString(LENGTH);
        }
        return key;
    }

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
	

	@Override
	public String encode(Object message) { 
		Message modelObject = new Message((String)message);
		if(!modelObject.msg.isEmpty()) {
			String str=modelObject.getMsg();
			String key = getKey()+Email.getEmailAddress();
	        str = str.replace(" ", key)+key;
	        String base64EncodedStr = Base64.getEncoder().encodeToString(str.getBytes());
	        StringBuilder encodedString = new StringBuilder();
	        encodedString.append("Encoded on ").append(DateFactory.getDateNow()).append("<br>"); 
	        encodedString.append(base64EncodedStr).append("<br>");
	        encodedString.append(getKey()).append("<br>");
			return encodedString.toString();
		}
			  
		return "unsupported mesage format";
	}

}
