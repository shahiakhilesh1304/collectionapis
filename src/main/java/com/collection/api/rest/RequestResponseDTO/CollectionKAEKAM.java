package com.collection.api.rest.RequestResponseDTO;

import java.util.Date;

public class CollectionKAEKAM 
{
	private String date;
	private String invoice;
	private String collection;
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date2 the date to set
	 */
	public void setDate(String date2) {
		this.date = date2;
	}
	/**
	 * @return the invoice
	 */
	public String getInvoice() {
		return invoice;
	}
	/**
	 * @param invoice the invoice to set
	 */
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	/**
	 * @return the collection
	 */
	public String getCollection() {
		return collection;
	}
	/**
	 * @param collection the collection to set
	 */
	public void setCollection(String collection) {
		this.collection = collection;
	}
	@Override
	public String toString() {
		return "CollectionKAEKAM [date=" + date + ", invoice=" + invoice + ", collection=" + collection + "]";
	}
	public CollectionKAEKAM(String date, String invoice, String collection) {
		this.date = date;
		this.invoice = invoice;
		this.collection = collection;
	}
	public CollectionKAEKAM() {
		// TODO Auto-generated constructor stub
	}
	
}
