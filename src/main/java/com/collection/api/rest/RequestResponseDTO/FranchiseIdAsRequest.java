package com.collection.api.rest.RequestResponseDTO;

public class FranchiseIdAsRequest 
{
	private int freanchise_id;

	/**
	 * @return the freanchise_id
	 */
	public int getFreanchise_id() {
		return freanchise_id;
	}

	/**
	 * @param freanchise_id the freanchise_id to set
	 */
	public void setFreanchise_id(int freanchise_id) {
		this.freanchise_id = freanchise_id;
	}

	@Override
	public String toString() {
		return "FranchiseIdAsRequest [freanchise_id=" + freanchise_id + "]";
	}

	public FranchiseIdAsRequest(int freanchise_id) {
		this.freanchise_id = freanchise_id;
	}

	public FranchiseIdAsRequest() {
		// TODO Auto-generated constructor stub
	}
	
}
