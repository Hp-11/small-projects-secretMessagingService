package org.hpyk.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.hpyk.model.Email;
import org.hpyk.model.Message;
import org.hpyk.model.handler.impl.UnifiedHandler;
import org.hpyk.service.DecoderService;
import org.hpyk.service.EncoderService;
import org.hpyk.service.helper.DateFactory;


public class DecoderServiceMessageImpl implements DecoderService<Message>{
	
	public DecoderServiceMessageImpl() {
		
	}
	public static String key = "";

	@Override
	public String decode(Object message) {
		System.out.println("In Decoder Service");
		Message modelObject = new Message((String) message);
		if(!modelObject.msg.isEmpty()) {
			String[] lines = modelObject.getMsg().split("\n");
	        if (lines.length < 2 ) {
	            return "Invalid encoded string";
	        }
	        String base64EncodedStr = lines[1].trim();
	        String originalKey = lines[2].trim();
	        setKey(originalKey+Email.getEmailAddress());
	        System.out.print(base64EncodedStr);
	        String decodedStr = new String(Base64.getDecoder().decode(base64EncodedStr),StandardCharsets.UTF_8);
	        System.out.print(key);
	        decodedStr = decodedStr.replace(key, " ");
	        StringBuilder decodedString = new StringBuilder();
	        decodedString.append("Decoded on ").append(DateFactory.getDateNow()).append("\n");
	        decodedString.append(decodedStr);
	        return decodedStr;
			 
		}
		
		return "unsupported mesage format";
	}

	private void setKey(String str) {
		this.key=str;
	}

}
