package weatherreport.weatherreport.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
	  private String latitude;
	  private String longitude;
	  private String date;
	  private String time;
	  private String temperature;
	  private String sunRiseTime;
	  private String sunsetTime;
	  private String temperatureHigh;
	  private String temperatureHighTime;
	  private String temperatureLow;
	  private String temperatureLowTime;
}
