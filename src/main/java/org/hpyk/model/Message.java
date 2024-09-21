package org.hpyk.model;

public class Message {

	public String msg; 
	

	public Message() 
	{	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Message(String msg) {
		super();
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "Message is: "+msg;
	}
	
}
