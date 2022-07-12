package com.collection.api.rest.RequestResponseDTO;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.collection.api.rest.model.EscrowBook;

public class DriverIdResponse 
{
	private String driver_name;
	private int plan_id;
	private String plan_name;
	private String plan_startdate;
	private int total_credit;
	private int total_invoice_generated;
	private int balance; 
	private int asset_serial_number;
	/**
	 * @return the driver_name
	 */
	public String getDriver_name() {
		return driver_name;
	}
	/**
	 * @param driver_name the driver_name to set
	 */
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	/**
	 * @return the plan_id
	 */
	public int getPlan_id() {
		return plan_id;
	}
	/**
	 * @param plan_id the plan_id to set
	 */
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	/**
	 * @return the plan_name
	 */
	public String getPlan_name() {
		return plan_name;
	}
	/**
	 * @param plan_name the plan_name to set
	 */
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	/**
	 * @return the plan_startdate
	 */
	public String getPlan_startdate() {
		return plan_startdate;
	}
	/**
	 * @param plan_startdate the plan_startdate to set
	 */
	public void setPlan_startdate(String plan_startdate) {
		this.plan_startdate = plan_startdate;
	}
	/**
	 * @return the total_credit
	 */
	public int getTotal_credit() {
		return total_credit;
	}
	/**
	 * @param total_credit the total_credit to set
	 */
	public void setTotal_credit(int total_credit) {
		this.total_credit = total_credit;
	}
	/**
	 * @return the total_invoice_generated
	 */
	public int getTotal_invoice_generated() {
		return total_invoice_generated;
	}
	/**
	 * @param total_invoice_generated the total_invoice_generated to set
	 */
	public void setTotal_invoice_generated(int total_invoice_generated) {
		this.total_invoice_generated = total_invoice_generated;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	/**
	 * @return the asset_serial_number
	 */
	public int getAsset_serial_number() {
		return asset_serial_number;
	}
	/**
	 * @param asset_serial_number the asset_serial_number to set
	 */
	public void setAsset_serial_number(int asset_serial_number) {
		this.asset_serial_number = asset_serial_number;
	}
	@Override
	public String toString() {
		return "DriverIdResponse [driver_name=" + driver_name + ", plan_id=" + plan_id + ", plan_name=" + plan_name
				+ ", plan_startdate=" + plan_startdate + ", total_credit=" + total_credit + ", total_invoice_generated="
				+ total_invoice_generated + ", balance=" + balance + ", asset_serial_number=" + asset_serial_number
				+ "]";
	}
	public DriverIdResponse(String driver_name, int plan_id, String plan_name, String plan_startdate, int total_credit,
			int total_invoice_generated, int balance, int asset_serial_number) {
		this.driver_name = driver_name;
		this.plan_id = plan_id;
		this.plan_name = plan_name;
		this.plan_startdate = plan_startdate;
		this.total_credit = total_credit;
		this.total_invoice_generated = total_invoice_generated;
		this.balance = balance;
		this.asset_serial_number = asset_serial_number;
	}
	public DriverIdResponse() {
		// TODO Auto-generated constructor stub
	}

	

	
}
