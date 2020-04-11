package weatherreport.weatherreport.controller;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;



import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import weatherreport.weatherreport.Service.WeatherService;
import weatherreport.weatherreport.entity.Weather;
/**
* The Controller to hit the weather API and fetch the results in the form of JSON response
*
* @author  Videet Kumar
* @version 1.0
* @since   2020-04-11 
*/

@RestController
public class WeatherController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value = "/search/{latitude}/{longitude}", method = RequestMethod.GET)
	public ArrayList<Weather> getWeatherData(@PathVariable String latitude, @PathVariable String longitude) throws IOException {

		String url = "https://api.darksky.net/forecast/0b67f8f549800f7bdeccc85500ba9324/";
	    long currentTime = System.currentTimeMillis()/1000;
	    String oneYearMilliS = "31556952000";
	    long oneYear = Long.parseLong(oneYearMilliS)/1000;
	    long oneYearBackTime = currentTime - oneYear;
	    ResponseEntity<String> currentResponse = restTemplate.getForEntity(url+latitude+","+longitude+","+currentTime, String.class);
	    ResponseEntity<String> OneYearBackResponse = restTemplate.getForEntity(url+latitude+","+longitude+","+oneYearBackTime, String.class);
	    ArrayList<Weather> result = new ArrayList<>();
	    WeatherService weatherService = new WeatherService();	    ;
	    result.add(weatherService.parseResponse(currentResponse, latitude, longitude, currentTime));
	    result.add(weatherService.parseResponse(OneYearBackResponse, latitude, longitude, oneYearBackTime));
	    return result;
	  }
}
