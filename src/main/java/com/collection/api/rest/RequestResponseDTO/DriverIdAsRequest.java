package com.collection.api.rest.RequestResponseDTO;

public class DriverIdAsRequest 
{
	private int driver_id;

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

	@Override
	public String toString() {
		return "DriverIdAsRequest [driver_id=" + driver_id + "]";
	}

	public DriverIdAsRequest(int driver_id) {
		this.driver_id = driver_id;
	}

	public DriverIdAsRequest() {
		// TODO Auto-generated constructor stub
	}
	
}
