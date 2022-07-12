package com.collection.api.rest.RequestResponseDTO;

import java.util.Date;

public class KaeKam
{
	private String kam;
	private String kae;
	private String franchise;
	private String driver_name;
	private String driver_id;
	private String payment_type;
	private String amount;
	private Date date;
	/**
	 * @return the kam
	 */
	public String getKam() {
		return kam;
	}
	/**
	 * @param kam the kam to set
	 */
	public void setKam(String kam) {
		this.kam = kam;
	}
	/**
	 * @return the kae
	 */
	public String getKae() {
		return kae;
	}
	/**
	 * @param kae the kae to set
	 */
	public void setKae(String kae) {
		this.kae = kae;
	}
	/**
	 * @return the franchise
	 */
	public String getFranchise() {
		return franchise;
	}
	/**
	 * @param franchise the franchise to set
	 */
	public void setFranchise(String franchise) {
		this.franchise = franchise;
	}
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
	 * @return the driver_id
	 */
	public String getDriver_id() {
		return driver_id;
	}
	/**
	 * @param driver_id the driver_id to set
	 */
	public void setDriver_id(String driver_id) {
		this.driver_id = driver_id;
	}
	/**
	 * @return the payment_type
	 */
	public String getPayment_type() {
		return payment_type;
	}
	/**
	 * @param payment_type the payment_type to set
	 */
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "KaeKam [kam=" + kam + ", kae=" + kae + ", franchise=" + franchise + ", driver_name="
				+ driver_name + ", driver_id=" + driver_id + ", payment_type=" + payment_type + ", amount=" + amount
				+ ", date=" + date + "]";
	}
	public KaeKam(String kam, String kae, String franchise, String driver_name, String driver_id,
			String payment_type, String amount, Date date) {
		this.kam = kam;
		this.kae = kae;
		this.franchise = franchise;
		this.driver_name = driver_name;
		this.driver_id = driver_id;
		this.payment_type = payment_type;
		this.amount = amount;
		this.date = date;
	}
	public KaeKam() {
		// TODO Auto-generated constructor stub
	}
	
	
}
