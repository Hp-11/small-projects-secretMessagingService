package org.hpyk.service.impl;

import java.io.File;

import org.hpyk.model.MessageFile;
import org.hpyk.model.handler.impl.UnifiedHandler;
import org.hpyk.service.DecoderService;
import org.hpyk.service.EncoderService;

public class DecoderServiceMessageFileImpl implements DecoderService<MessageFile>{
	
	protected MessageFile mFile;
	
	public DecoderServiceMessageFileImpl(MessageFile file) {
		mFile = file;
	}
	

	public DecoderServiceMessageFileImpl() {
		super(); 
	}


	@Override
	public byte[] decode(Object message) {	
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
