package org.hpyk.model;

public class Email {
	public static String emailAddress;

	public static String getEmailAddress() {
		return emailAddress;
	}

	public static void setEmailAddress(String emailAdd) {
		if(emailAdd!=null)
		Email.emailAddress = emailAdd;
	}

	 
}
