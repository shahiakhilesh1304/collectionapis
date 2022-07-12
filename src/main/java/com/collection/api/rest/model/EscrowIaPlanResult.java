package com.collection.api.rest.model;

public class EscrowIaPlanResult 
{
	private int asset_id;
	private String plan_name;
	private int amount;
	private int balance;
	private String payment_type;

	public int getAsset_id() {
		return asset_id;
	}
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getPayment_type() {
		return payment_type;
	}
	public void setPayment_type(String payment_type) {
		this.payment_type = payment_type;
	}
	@Override
	public String toString() {
		return "EscrowIaPlanResult [asset_id=" + asset_id + ", plan_name=" + plan_name + ", amount=" + amount
				+ ", balance=" + balance + ", payment_type=" + payment_type + "]";
	}
	public EscrowIaPlanResult(int asset_id, String plan_name, int amount, int balance, String payment_type) {
		this.asset_id = asset_id;
		this.plan_name = plan_name;
		this.amount = amount;
		this.balance = balance;
		this.payment_type = payment_type;
	}
	public EscrowIaPlanResult() {
	}
	
}
