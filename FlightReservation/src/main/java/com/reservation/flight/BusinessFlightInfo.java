package com.reservation.flight;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * 
 * @author Qazi Atif
 *
 */
public class BusinessFlightInfo implements Cloneable, Comparable<BusinessFlightInfo>{
	private String uuid;
	private String flight;
	private String arrival;
	private String departure;
	
	public BusinessFlightInfo() {
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
	}
	public String getFlight() {
		return flight;
	}
	public void setFlight(String flight) {
		this.flight = flight;
	}
	public Object clone() throws CloneNotSupportedException
	{
		BusinessFlightInfo clonedFlightInfo=new BusinessFlightInfo();
		clonedFlightInfo.setArrival(this.arrival);
		clonedFlightInfo.setDeparture(this.departure);
		clonedFlightInfo.setFlight(this.flight);
		clonedFlightInfo.setUuid(this.uuid);
		return clonedFlightInfo;
	}
	
	public int compareTo(BusinessFlightInfo newBusiness) {
        int retVal = 0;
        try {
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);
			LocalDateTime date1 = LocalDateTime.parse(this.getDeparture(), formatter);
			LocalDateTime date2 = LocalDateTime.parse(newBusiness.getDeparture(), formatter);
			
			if(date2.isAfter(date1))
                retVal = 1;
            else if(date2.isBefore(date1))
                retVal = -1;
            else {
       			retVal=0;
            }
        }
        catch(Exception ex) {
        	//logger.error(ex.getMessage(),ex);
        }
        return retVal;
    }

	
}
