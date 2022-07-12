package com.collection.api.rest.RequestResponseDTO;

public class KaeRequest 
{
	private int kae;

	/**
	 * @return the kae
	 */
	public int getKae() {
		return kae;
	}

	/**
	 * @param kae the kae to set
	 */
	public void setKae(int kae) {
		this.kae = kae;
	}

	@Override
	public String toString() {
		return "KaeRequest [kae=" + kae + "]";
	}

	public KaeRequest(int kae) {
		this.kae = kae;
	}

	public KaeRequest() {
		// TODO Auto-generated constructor stub
	}

	
}
