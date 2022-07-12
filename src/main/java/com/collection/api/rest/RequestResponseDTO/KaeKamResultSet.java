package com.collection.api.rest.RequestResponseDTO;

import java.util.Date;

public class KaeKamResultSet 
{
	private String kae;
	private String kam;
	private String name;
	private String franchise;
	private String driver_id;
	private String payment_type;
	private String amount;
	private String date;
	private String planname;
	private String plandepositamount;
	private String leave_status;
	private String srno;
	private String ticketstatus;
	private String datecreated;
	private String closingdate;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the planname
	 */
	public String getPlanname() {
		return planname;
	}
	/**
	 * @param planname the planname to set
	 */
	public void setPlanname(String planname) {
		this.planname = planname;
	}
	/**
	 * @return the plandepositamount
	 */
	public String getPlandepositamount() {
		return plandepositamount;
	}
	/**
	 * @param plandepositamount the plandepositamount to set
	 */
	public void setPlandepositamount(String plandepositamount) {
		this.plandepositamount = plandepositamount;
	}
	/**
	 * @return the leave_status
	 */
	public String getLeave_status() {
		return leave_status;
	}
	/**
	 * @param leave_status the leave_status to set
	 */
	public void setLeave_status(String leave_status) {
		this.leave_status = leave_status;
	}
	/**
	 * @return the srno
	 */
	public String getSrno() {
		return srno;
	}
	/**
	 * @param srno the srno to set
	 */
	public void setSrno(String srno) {
		this.srno = srno;
	}
	/**
	 * @return the ticketstatus
	 */
	public String getTicketstatus() {
		return ticketstatus;
	}
	/**
	 * @param ticketstatus the ticketstatus to set
	 */
	public void setTicketstatus(String ticketstatus) {
		this.ticketstatus = ticketstatus;
	}
	/**
	 * @return the datecreated
	 */
	public String getDatecreated() {
		return datecreated;
	}
	/**
	 * @param datecreated the datecreated to set
	 */
	public void setDatecreated(String datecreated) {
		this.datecreated = datecreated;
	}
	/**
	 * @return the closingdate
	 */
	public String getClosingdate() {
		return closingdate;
	}
	/**
	 * @param closingdate the closingdate to set
	 */
	public void setClosingdate(String closingdate) {
		this.closingdate = closingdate;
	}
	@Override
	public String toString() {
		return "KaeKamResultSet [kae=" + kae + ", kam=" + kam + ", name=" + name + ", franchise=" + franchise
				+ ", driver_id=" + driver_id + ", payment_type=" + payment_type + ", amount=" + amount + ", date="
				+ date + ", planname=" + planname + ", plandepositamount=" + plandepositamount + ", leave_status="
				+ leave_status + ", srno=" + srno + ", ticketstatus=" + ticketstatus + ", datecreated=" + datecreated
				+ ", closingdate=" + closingdate + "]";
	}
	public KaeKamResultSet(String kae, String kam, String name, String franchise, String driver_id, String payment_type,
			String amount, String date, String planname, String plandepositamount, String leave_status, String srno,
			String ticketstatus, String datecreated, String closingdate) {
		this.kae = kae;
		this.kam = kam;
		this.name = name;
		this.franchise = franchise;
		this.driver_id = driver_id;
		this.payment_type = payment_type;
		this.amount = amount;
		this.date = date;
		this.planname = planname;
		this.plandepositamount = plandepositamount;
		this.leave_status = leave_status;
		this.srno = srno;
		this.ticketstatus = ticketstatus;
		this.datecreated = datecreated;
		this.closingdate = closingdate;
	}
	public KaeKamResultSet() {
		// TODO Auto-generated constructor stub
	}



}
