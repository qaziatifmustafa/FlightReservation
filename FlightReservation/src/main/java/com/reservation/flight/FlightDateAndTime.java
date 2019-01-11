package com.reservation.flight;
/**
 * 
 * @author Qazi Atif
 *
 */

import java.beans.PropertyEditorSupport;
import java.util.Date;

public class FlightDateAndTime extends PropertyEditorSupport{

	@Override
	public void setAsText(String departureTime) throws IllegalArgumentException{
		long timestamp = Long.parseLong(departureTime); //Example -> in ms
		Date d = new Date(timestamp );
		setValue(d);
	}
}
