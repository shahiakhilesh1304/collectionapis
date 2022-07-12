package com.collection.api.rest.RequestResponseDTO;

import java.util.List;

public class KaeKamReponseReport {
	private String kam;
	private String kae;
	private String franchise;
	private String driver_name;
	private List<CollectionKAEKAM> collection;
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
	 * @return the collection
	 */
	public List<CollectionKAEKAM> getCollection() {
		return collection;
	}
	/**
	 * @param collection the collection to set
	 */
	public void setCollection(List<CollectionKAEKAM> collection) {
		this.collection = collection;
	}
	@Override
	public String toString() {
		return "KaeKamReponseReport [kam=" + kam + ", kae=" + kae + ", franchise=" + franchise + ", driver_name="
				+ driver_name + ", collection=" + collection + "]";
	}
	public KaeKamReponseReport(String kam, String kae, String franchise, String driver_name,
			List<CollectionKAEKAM> collection) {
		this.kam = kam;
		this.kae = kae;
		this.franchise = franchise;
		this.driver_name = driver_name;
		this.collection = collection;
	}
	public KaeKamReponseReport() {
		// TODO Auto-generated constructor stub
	}

}
