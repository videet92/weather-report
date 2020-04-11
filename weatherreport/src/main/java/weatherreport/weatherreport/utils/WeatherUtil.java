package weatherreport.weatherreport.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class WeatherUtil {
	public LocalDateTime convertEpochToDate(long longValue) {
		//return Instant.ofEpochMilli(longValue).atZone(ZoneId.systemDefault()).toLocalDate();
	    Instant instant = Instant.ofEpochMilli(longValue);
	    LocalDateTime date = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();
	    return date;
	}
	public LocalDate convertStringEpochToDate(String longValue) {
		long oneYear = Long.parseLong(longValue)/1000;
		LocalDate date =
			    Instant.ofEpochMilli(oneYear).atZone(ZoneId.systemDefault()).toLocalDate();
		return date;
	}
}
