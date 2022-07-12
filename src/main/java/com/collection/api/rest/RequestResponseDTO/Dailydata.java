package com.collection.api.rest.RequestResponseDTO;

import java.util.Date;

public class Dailydata 
{
	private String date;
	private int totalAmount;
	private int totalBalance;
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
	/**
	 * @return the totalAmount
	 */
	public int getTotalAmount() {
		return totalAmount;
	}
	/**
	 * @param totalAmount the totalAmount to set
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
	/**
	 * @return the totalBalance
	 */
	public int getTotalBalance() {
		return totalBalance;
	}
	/**
	 * @param totalBalance the totalBalance to set
	 */
	public void setTotalBalance(int totalBalance) {
		this.totalBalance = totalBalance;
	}
	@Override
	public String toString() {
		return "Dailydata [date=" + date + ", totalAmount=" + totalAmount + ", totalBalance=" + totalBalance + "]";
	}
	public Dailydata(String date, int totalAmount, int totalBalance) {
		this.date = date;
		this.totalAmount = totalAmount;
		this.totalBalance = totalBalance;
	}
	public Dailydata() {
		// TODO Auto-generated constructor stub
	}
	
	

}
