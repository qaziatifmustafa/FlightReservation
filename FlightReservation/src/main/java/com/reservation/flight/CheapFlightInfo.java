package com.reservation.flight;

import java.util.Date;

/**
 * 
 * @author Qazi Atif
 *
 */

public class CheapFlightInfo  implements Cloneable, Comparable<CheapFlightInfo>{

	private Long id;
	private String departure;
	private String arrival;
	private Long departureTime;
	private Long arrivalTime;
	
	
	public CheapFlightInfo() {
	}
	public CheapFlightInfo(Long id, String departure, String arrival,Long departureTime,Long arrivalTime) {
		super();
		this.id = id;
		this.departure = departure;
		this.arrival = arrival;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Long getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(Long departureTime) {
		this.departureTime = departureTime;
	}
	public Long getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(Long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public Object clone() throws CloneNotSupportedException
	{
		CheapFlightInfo clonedFlightInfo=new CheapFlightInfo();
		clonedFlightInfo.setArrival(this.arrival);
		clonedFlightInfo.setDeparture(this.departure);
		clonedFlightInfo.setArrivalTime(this.arrivalTime);
		clonedFlightInfo.setDepartureTime(this.departureTime);
		clonedFlightInfo.setId(this.id);
		return clonedFlightInfo;
	}
	
	public int compareTo(CheapFlightInfo newCheap) {
        int retVal = 0;
        try {
            Long timestamp1 = this.getDepartureTime();
            Long timestamp2 = newCheap.getDepartureTime();
			Date date1 = new Date(timestamp1 );
			Date date2 = new Date(timestamp2);
            if(date2.after(date1))
                retVal = 1;
            else if(date2.before(date1))
                retVal = -1;
            else {
       			retVal=0;
            }
        }
        catch(Exception ex) {
//        	logger.error(ex.getMessage(),ex);
        }
        return retVal;
    }
	
}
