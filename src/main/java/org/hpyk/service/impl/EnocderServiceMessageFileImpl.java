package org.hpyk.service.impl;

import java.io.File;

import org.hpyk.model.MessageFile;
import org.hpyk.model.handler.impl.UnifiedHandler;
import org.hpyk.service.EncoderService;

public class EnocderServiceMessageFileImpl implements EncoderService<MessageFile>{
	
	protected MessageFile mFile;
	
	public EnocderServiceMessageFileImpl(MessageFile file) {
		mFile = file;
	}
	

	public EnocderServiceMessageFileImpl() {
		super(); 
	}


	@Override
	public byte[] encode(Object message) {	
		MessageFile FObject = new MessageFile((File)message);
		   
		if(validated()) {
			//do stuff result
			return  FObject.toString().getBytes();
		}
		
			
		return "unsupported mesage format".getBytes();
	}


	private boolean validated() {
		// TODO Auto-generated method stub
		return false;
	}

}
