package weatherreport.weatherreport.Service;

import java.util.Iterator;
import java.util.Objects;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import weatherreport.weatherreport.entity.Weather;
import weatherreport.weatherreport.utils.WeatherUtil;

public class WeatherService {
	
	public Weather parseResponse(ResponseEntity<String> response, String latitude, String longitude, Long time) throws JsonMappingException, JsonProcessingException {
		WeatherUtil util = new WeatherUtil();
		
		JsonNode responseNode = new ObjectMapper().readTree(Objects.requireNonNull(response.getBody()));
		Weather weatherData = new Weather();
		weatherData.setLongitude(longitude);
		weatherData.setLatitude(latitude);
		weatherData.setTemperature(responseNode.get("currently").get("temperature").toString());
	    ArrayNode dailyData = (ArrayNode) responseNode.get("daily").get("data");
	    Iterator<JsonNode> dailyIterator = dailyData.elements();
	    while (dailyIterator.hasNext()) {
	      JsonNode dailyNode = dailyIterator.next();
	      weatherData.setSunRiseTime(util.convertStringEpochToDate(dailyNode.get("sunriseTime").toString()));
	      weatherData.setSunsetTime(util.convertStringEpochToDate(dailyNode.get("sunsetTime").toString()));
	      weatherData.setTemperatureHigh(dailyNode.get("temperatureHigh").toString());
	      weatherData.setTemperatureHighTime(util.convertStringEpochToDate(dailyNode.get("temperatureHighTime").toString()));
	      weatherData.setTemperatureLow(dailyNode.get("temperatureLow").toString());
	      weatherData.setTemperatureLowTime(util.convertStringEpochToDate(dailyNode.get("temperatureLowTime").toString()));
	    }
	    
	    weatherData.setDate(util.convertEpochToDate(time));
	    weatherData.setTime(util.convertEpochToTime(time));
	    return weatherData;
	}	
}
