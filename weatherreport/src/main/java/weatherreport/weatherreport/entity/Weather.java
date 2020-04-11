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
	  private LocalDateTime date;
	  private String time;
	  private String temperature;
	  private LocalDate sunRiseTime;
	  private LocalDate sunsetTime;
	  private String temperatureHigh;
	  private LocalDate temperatureHighTime;
	  private String temperatureLow;
	  private LocalDate temperatureLowTime;
}
