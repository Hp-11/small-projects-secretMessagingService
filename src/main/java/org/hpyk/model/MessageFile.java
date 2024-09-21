package org.hpyk.model;

import java.io.File;

public class MessageFile {
	
	public File file; 

	  
	public MessageFile(File file) {
		super();
		this.file = file;
	}

	public MessageFile() {
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}
	
	@Override
	public String toString() {
		if(file!=null) {
			return "file : "+file.getName()+" : of size :"+file.getTotalSpace();
		}
		return "File is not initialized yet";
	}
	
}
