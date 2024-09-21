package org.hpyk.service.helper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFactory {
	public static String getDateNow() {
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd"));
	}
}
