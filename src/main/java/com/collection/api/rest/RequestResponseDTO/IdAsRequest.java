package com.collection.api.rest.RequestResponseDTO;

public class IdAsRequest {
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "DeleteRequest [id=" + id + "]";
	}

	public IdAsRequest(int id) {
		this.id = id;
	}

	public IdAsRequest() {
		// TODO Auto-generated constructor stub
	}
	
}
