package com.reservation.flight;
/**
 * 
 * @author Qazi Atif
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightController {
	@Autowired
	private FlightService flightService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		/*SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		binder.registerCustomEditor(Date.class,"departureTime", new CustomDateEditor(dateFormat,false));
		*/
		binder.registerCustomEditor(String.class,"departureTime", new FlightDateAndTime());
	}
	
	
	@RequestMapping("/businessFlights")
	public ArrayList getAllBusinessFlight() {
		return flightService.getBusinessFlightList();
	}
	@RequestMapping("/cheapFlights")
	public ArrayList  getAllCheapFlight() {
		return flightService.getCheapFlightList();
	}
	@RequestMapping("/availableBusinessFlights")
	public ArrayList getAvailableBusinessFlight() {
		return flightService.getAvailableBusinessFlightList();
	}
	@RequestMapping("/availableCheapFlights")
	public ArrayList  getAvaiblableCheapFlight() {
		return flightService.getAvailableCheapFlightList();
	}
	@RequestMapping("/businessFlight/{uuid}")
	public BusinessFlightInfo getBusinessFlightInfo(@PathVariable String uuid) {
		return flightService.getBusinessFlight(uuid);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cheapFlights")
	public void addCheapFlight(@RequestBody Object cheapFlightInfo) {
		flightService.addCheapFlights((ArrayList)cheapFlightInfo);
	}
	@RequestMapping(method=RequestMethod.POST,value="/businessFlights")
	public void addBusinessFlight(@RequestBody Object businessFlightInfo) {
		flightService.addBusinessFlights((ArrayList)businessFlightInfo);
	}
	@RequestMapping("/aggregatedFlights")
	public HashMap addAggregatedFlight() {
		return flightService.getAggregatedFlightList();
	}
	
}
