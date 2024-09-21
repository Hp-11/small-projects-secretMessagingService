package org.hpyk.model.handler.impl;

import java.io.File;

import org.hpyk.model.Email;
import org.hpyk.model.Message;
import org.hpyk.model.MessageFile;
import org.hpyk.model.handler.MObject;
import org.hpyk.service.impl.DecoderServiceMessageFileImpl;
import org.hpyk.service.impl.DecoderServiceMessageImpl;
import org.hpyk.service.impl.EnocderServiceMessageFileImpl;
import org.hpyk.service.impl.EnocderServiceMessageImpl;

public class UnifiedHandler implements MObject<Object>{

	public Object T;
	
	public Object getT() {
		return T;
	}

	public void setT(Object t) {
		T = t;
	}
	public UnifiedHandler For(Object t) {
		T=t;
		return this;
	}

	public UnifiedHandler(Object t) {
		super();
		T = t;
	}

	public UnifiedHandler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object getObjectForEncoding(String email) {
		 if(getT() instanceof String) {
			T = new Message();
			Email.setEmailAddress(email); 
			 return new EnocderServiceMessageImpl();
		 }
		 if(getT() instanceof File) { 
			 T = new MessageFile();
			 Email.setEmailAddress(email); 
			 return new EnocderServiceMessageFileImpl();
		 }
		 return getT();
	}
	
	@Override
	public Object getObjectForDecoding(String email) {
		System.out.print("In unifiedhandler" + email);
		 if(getT() instanceof String) { 
				Email.setEmailAddress(email);
				T = new Message(); 
			 return new DecoderServiceMessageImpl();
		 }
		 if(getT() instanceof File) {
			 T = new MessageFile();
			 Email.setEmailAddress(email); 
			 return new DecoderServiceMessageFileImpl();
		 }
		 return getT();
	}

}