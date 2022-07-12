package com.collection.api.rest.RequestResponseDTO;

import java.util.Date;

public class DriverIdAndDateAsRequest 
{
	private int driver_id;
	private String date;
	/**
	 * @return the driver_id
	 */
	public int getDriver_id() {
		return driver_id;
	}
	/**
	 * @param driver_id the driver_id to set
	 */
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "DriverIdAndDateAsRequest [driver_id=" + driver_id + ", date=" + date + "]";
	}
	public DriverIdAndDateAsRequest(int driver_id, String date) {
		this.driver_id = driver_id;
		this.date = date;
	}
	public DriverIdAndDateAsRequest() {
		// TODO Auto-generated constructor stub
	}
	
}
