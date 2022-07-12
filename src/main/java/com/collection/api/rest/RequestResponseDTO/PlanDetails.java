package com.collection.api.rest.RequestResponseDTO;

import java.util.Date;

public class PlanDetails 
{
	private String plan_name;
	private String driver_name;
	private Date plan_start_date;
	private String planid;
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
	 * @return the plan_start_date
	 */
	public Date getPlan_start_date() {
		return plan_start_date;
	}
	/**
	 * @param plan_start_date the plan_start_date to set
	 */
	public void setPlan_start_date(Date plan_start_date) {
		this.plan_start_date = plan_start_date;
	}
	/**
	 * @return the planid
	 */
	public String getPlanid() {
		return planid;
	}
	/**
	 * @param planid the planid to set
	 */
	public void setPlanid(String planid) {
		this.planid = planid;
	}
	@Override
	public String toString() {
		return "PlanDetails [plan_name=" + plan_name + ", driver_name=" + driver_name + ", plan_start_date="
				+ plan_start_date + ", planid=" + planid + "]";
	}
	public PlanDetails(String plan_name, String driver_name, Date plan_start_date, String planid) {
		this.plan_name = plan_name;
		this.driver_name = driver_name;
		this.plan_start_date = plan_start_date;
		this.planid = planid;
	}
	public PlanDetails() {
		// TODO Auto-generated constructor stub
	}
	
}
