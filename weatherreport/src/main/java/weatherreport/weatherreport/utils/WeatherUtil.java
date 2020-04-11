package weatherreport.weatherreport.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class WeatherUtil {
	public String convertEpochToDate(long longValue) {

	    return new java.text.SimpleDateFormat("MM/dd/yyyy").format(new java.util.Date (longValue*1000));
	}
	public String convertStringEpochToDate(String longValue) {
		long longDate = Long.parseLong(longValue)/1000;
		return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (longDate*1000));
	}
	public String convertEpochToTime(long longValue) {

	    return new java.text.SimpleDateFormat("HH:mm:ss").format(new java.util.Date (longValue*1000));
	}
}
