package com.collection.api.rest.RequestResponseDTO;

public class DateCreatedRequest 
{
	private String date_created;

	/**
	 * @return the date_created
	 */
	public String getDate_created() {
		return date_created;
	}

	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(String date_created) {
		this.date_created = date_created;
	}

	@Override
	public String toString() {
		return "DateCreatedRequest [date_created=" + date_created + "]";
	}

	public DateCreatedRequest(String date_created) {
		this.date_created = date_created;
	}

	public DateCreatedRequest() {
		// TODO Auto-generated constructor stub
	}
	
}
