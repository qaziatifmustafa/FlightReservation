package com.reservation.flight;
/**
 * 
 * @author Qazi Atif
 *
 */

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class FlightService {
	List <BusinessFlightInfo> businessList;
	
	private ArrayList<HashMap> cheapServicesInfo;
	private ArrayList<HashMap> businessServicesInfo;
	
	public List<BusinessFlightInfo> getAllBusinessFlight() {
		// TODO Auto-generated method stub
		//List<BusinessFlightInfo> businessList = new ArrayList<>();
		//businessFlightRepository.findAll().forEach(businessList::add);
		return businessList;
	}
	
	public BusinessFlightInfo getBusinessFlight(String id) {
		return businessList.stream().filter(t -> t.getUuid().equals(id)).findFirst().get();
	}

	
	public void addBusinessFlights(ArrayList businessFlightInfo) {
		// TODO Auto-generated method stub
		this.businessServicesInfo = businessFlightInfo;
		
	}
	public void addCheapFlights(ArrayList cheapFlightInfo) {
		// TODO Auto-generated method stub
		this.cheapServicesInfo = cheapFlightInfo;
		
	}

	public ArrayList<CheapFlightInfo> getCheapFlightList() {
		// TODO Auto-generated method stub
		ArrayList<CheapFlightInfo> returnList = new ArrayList<CheapFlightInfo>();
		for(int count = 0;count<cheapServicesInfo.size();count++) {
			Map map = (HashMap) cheapServicesInfo.get(count);
			/*Long timestamp = Long.parseLong((String)map.get("departureTime"));
			Date d = new Date(timestamp );*/
			CheapFlightInfo cheapFlight= new CheapFlightInfo();
			cheapFlight.setId((Long) map.get("id"));
			cheapFlight.setArrival((String) map.get("arrival"));
			cheapFlight.setDeparture((String) map.get("departure"));
			cheapFlight.setArrivalTime((Long) map.get("arrivalTime"));
			cheapFlight.setDepartureTime( (Long)map.get("departureTime"));
			returnList.add(cheapFlight);
			
		}
		return returnList;
	}

	public ArrayList<CheapFlightInfo> getAvailableCheapFlightList() {
		// TODO Auto-generated method stub
		ArrayList<CheapFlightInfo> returnList = new ArrayList<CheapFlightInfo>();
		ArrayList<CheapFlightInfo> allCheapList = getCheapFlightList();
		for(CheapFlightInfo cFlightInfo : allCheapList) {
			Long timestamp = cFlightInfo.getDepartureTime();
			Date d = new Date(timestamp );
			if(d.after(new Date())) {
				returnList.add(cFlightInfo);
			}
		}
		Collections.sort(returnList);
		return returnList;
	}
	public ArrayList<BusinessFlightInfo> getBusinessFlightList() {
		// TODO Auto-generated method stub
		ArrayList<BusinessFlightInfo> returnList = new ArrayList<BusinessFlightInfo>();
		for(int count = 0;count<businessServicesInfo.size();count++) {
			Map map = (HashMap) businessServicesInfo.get(count);
			String id = (String)map.get("uuid");
			String dString = (String)map.get("departure");
			String aString = (String)map.get("arrival");
			String flight = (String)map.get("flight");
			/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			LocalDateTime date = LocalDateTime.parse(dString, formatter);*/
			BusinessFlightInfo businessFlight= new BusinessFlightInfo();
			businessFlight.setUuid(id);
			businessFlight.setDeparture(dString);
			//businessFlight.setArrival(LocalDateTime.parse(aString, formatter).toString());
			businessFlight.setArrival(aString);
			businessFlight.setFlight(flight);
			returnList.add(businessFlight);
			
		}
		return returnList;
	}
	
	public ArrayList<BusinessFlightInfo> getAvailableBusinessFlightList() {
		// TODO Auto-generated method stub
		ArrayList<BusinessFlightInfo> returnList = new ArrayList<BusinessFlightInfo>();
		ArrayList<BusinessFlightInfo> allBusinessList = getBusinessFlightList();
		for(BusinessFlightInfo bFlightInfo : allBusinessList) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			LocalDateTime date = LocalDateTime.parse(bFlightInfo.getDeparture(), formatter);
			if(date.isAfter(LocalDateTime.now()))
				returnList.add(bFlightInfo);
			
		}
		Collections.sort(returnList);
		return returnList;
	}
	
	public HashMap getAggregatedFlightList() {
		ArrayList<BusinessFlightInfo> list1=getAvailableBusinessFlightList();
		ArrayList<CheapFlightInfo> list2=getAvailableCheapFlightList();
		HashMap<String,ArrayList> flights= new HashMap<String,ArrayList>();
		if(list1 != null && list1.size() > 0)
			flights.put("businessFlights", list1);
		if(list2 != null && list2.size() > 0)
			flights.put("cheapFlights", list2);
		
		return flights;
		
		
	}
}
