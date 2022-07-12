package com.collection.api.rest.RequestResponseDTO;

import java.util.List;

import com.collection.api.rest.model.EscrowBook;


public class Date_DriverIdResponse 
{
	private List<Dailydata> dailyGross;
	private List<EscrowBook> dateData;

	public List<Dailydata> getDailyGross() {
		return dailyGross;
	}
	public void setDailyGross(List<Dailydata> dailyGross) {
		this.dailyGross = dailyGross;
	}
	public  List<EscrowBook> getDateData() {
		return dateData;
	}
	public void setDateData( List<EscrowBook> dateData) {
		this.dateData = dateData;
	}
	@Override
	public String toString() {
		return "Date_DriverIdResponse [dailyGross=" + dailyGross + ", dateData=" + dateData + "]";
	}
	public Date_DriverIdResponse() {
	}
	public Date_DriverIdResponse(List<Dailydata> dailyGross, List<EscrowBook> dateData) {
		this.dailyGross = dailyGross;
		this.dateData = dateData;
	}
	


}
