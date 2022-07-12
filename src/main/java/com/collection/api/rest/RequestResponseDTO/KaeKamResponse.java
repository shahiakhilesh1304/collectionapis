package com.collection.api.rest.RequestResponseDTO;

import java.util.List;

public class KaeKamResponse 
{
	private String kam;
	private String kae;
	private String franchise;
	private String planname;
	private String plandepositamount;
	private String driver_name;
	private String driver_id;
	private String payment_type;
	private String amount;
	private String date_created;
	private String serialnumber;
	private String leaveStatus;
	private String ticketstatus;
	private String opendate;
	private String closedate;
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
	/**
	 * @return the serialnumber
	 */
	public String getSerialnumber() {
		return serialnumber;
	}
	/**
	 * @param serialnumber the serialnumber to set
	 */
	public void setSerialnumber(String serialnumber) {
		this.serialnumber = serialnumber;
	}
	/**
	 * @return the leaveStatus
	 */
	public String getLeaveStatus() {
		return leaveStatus;
	}
	/**
	 * @param leaveStatus the leaveStatus to set
	 */
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
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
	 * @return the opendate
	 */
	public String getOpendate() {
		return opendate;
	}
	/**
	 * @param opendate the opendate to set
	 */
	public void setOpendate(String opendate) {
		this.opendate = opendate;
	}
	/**
	 * @return the closedate
	 */
	public String getClosedate() {
		return closedate;
	}
	/**
	 * @param closedate the closedate to set
	 */
	public void setClosedate(String closedate) {
		this.closedate = closedate;
	}
	@Override
	public String toString() {
		return "KaeKamResponse [kam=" + kam + ", kae=" + kae + ", franchise=" + franchise + ", planname=" + planname
				+ ", plandepositamount=" + plandepositamount + ", driver_name=" + driver_name + ", driver_id="
				+ driver_id + ", payment_type=" + payment_type + ", amount=" + amount + ", date_created=" + date_created
				+ ", serialnumber=" + serialnumber + ", leaveStatus=" + leaveStatus + ", ticketstatus=" + ticketstatus
				+ ", opendate=" + opendate + ", closedate=" + closedate + "]";
	}
	public KaeKamResponse(String kam, String kae, String franchise, String planname, String plandepositamount,
			String driver_name, String driver_id, String payment_type, String amount, String date_created,
			String serialnumber, String leaveStatus, String ticketstatus, String opendate, String closedate) {
		this.kam = kam;
		this.kae = kae;
		this.franchise = franchise;
		this.planname = planname;
		this.plandepositamount = plandepositamount;
		this.driver_name = driver_name;
		this.driver_id = driver_id;
		this.payment_type = payment_type;
		this.amount = amount;
		this.date_created = date_created;
		this.serialnumber = serialnumber;
		this.leaveStatus = leaveStatus;
		this.ticketstatus = ticketstatus;
		this.opendate = opendate;
		this.closedate = closedate;
	}
	public KaeKamResponse() {
		// TODO Auto-generated constructor stub
	}

}
