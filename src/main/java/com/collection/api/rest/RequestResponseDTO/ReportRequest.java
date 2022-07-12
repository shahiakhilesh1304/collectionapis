package com.collection.api.rest.RequestResponseDTO;

public class ReportRequest 
{
	private String kae;
	private String kam;
	private String franchise;
	private String driver_id;
	private String yyyyMM;
	private String bwDates;
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
	 * @return the yyyyMM
	 */
	public String getYyyyMM() {
		return yyyyMM;
	}
	/**
	 * @param yyyyMM the yyyyMM to set
	 */
	public void setYyyyMM(String yyyyMM) {
		this.yyyyMM = yyyyMM;
	}
	/**
	 * @return the bwDates
	 */
	public String getBwDates() {
		return bwDates;
	}
	/**
	 * @param bwDates the bwDates to set
	 */
	public void setBwDates(String bwDates) {
		this.bwDates = bwDates;
	}
	@Override
	public String toString() {
		return "ReportRequest [kae=" + kae + ", kam=" + kam + ", franchise=" + franchise + ", driver_id=" + driver_id
				+ ", yyyyMM=" + yyyyMM + ", bwDates=" + bwDates + "]";
	}
	public ReportRequest(String kae, String kam, String franchise, String driver_id, String yyyyMM, String bwDates) {
		this.kae = kae;
		this.kam = kam;
		this.franchise = franchise;
		this.driver_id = driver_id;
		this.yyyyMM = yyyyMM;
		this.bwDates = bwDates;
	}
	public ReportRequest() {
		// TODO Auto-generated constructor stub
	}

	
}
