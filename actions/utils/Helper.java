package utils;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {
	public static Helper initialHelper() {
		return new Helper();
	}

	// Return current date with format MMM day
	public String getCurrentDate() {
		Format f = new SimpleDateFormat("MMM d");
		String strMonthDate = f.format(new Date());
		return strMonthDate;
	}

}
