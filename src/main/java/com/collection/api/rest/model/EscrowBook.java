package com.collection.api.rest.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "escrow_book")
public class EscrowBook
{

	@Transient
	public static final String SEQUENCE_NAME = "escrobook_sequence";	
	
	@Id
	private String id;
	private int col_id;	
	private String transaction_id;
	private String transaction_ref_no;	
	private int plan_id;
	private int amount;	
	private String payment_type;	
	private String payment_mode;	
	private String status;
	private Date date_created;
	private Date date_modified;
	private int driver_id;
	private int asset_id;
	private int franchise_id;
	private String asset_name;
	private int balance;	
	private String created_by;	
	private String source_creation;
	private Date system_created_date;
	private Boolean is_deleted;
	private String deleted_by;
	private Date deleted_date;
	private Boolean is_expired;
	
	
	/**
	 * @return the col_id
	 */
	public int getCol_id() {
		return col_id;
	}
	/**
	 * @param col_id the col_id to set
	 */
	public void setCol_id(int col_id) {
		this.col_id = col_id;
	}
	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}
	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}
	/**
	 * @return the transaction_ref_no
	 */
	public String getTransaction_ref_no() {
		return transaction_ref_no;
	}
	/**
	 * @param transaction_ref_no the transaction_ref_no to set
	 */
	public void setTransaction_ref_no(String transaction_ref_no) {
		this.transaction_ref_no = transaction_ref_no;
	}
	/**
	 * @return the plan_id
	 */
	public int getPlan_id() {
		return plan_id;
	}
	/**
	 * @param plan_id the plan_id to set
	 */
	public void setPlan_id(int plan_id) {
		this.plan_id = plan_id;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
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
	 * @return the payment_mode
	 */
	public String getPayment_mode() {
		return payment_mode;
	}
	/**
	 * @param payment_mode the payment_mode to set
	 */
	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the date_created
	 */
	public Date getDate_created() {
		return date_created;
	}
	/**
	 * @param date_created the date_created to set
	 */
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	/**
	 * @return the date_modified
	 */
	public Date getDate_modified() {
		return date_modified;
	}
	/**
	 * @param date_modified the date_modified to set
	 */
	public void setDate_modified(Date date_modified) {
		this.date_modified = date_modified;
	}
	/**
	 * @return the driver_id
	 */
	public int getDriver_id() {
		return driver_id;
	}
	/**
	 * @param driver_id the driver_id to set
	 */
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	/**
	 * @return the asset_id
	 */
	public int getAsset_id() {
		return asset_id;
	}
	/**
	 * @param asset_id the asset_id to set
	 */
	public void setAsset_id(int asset_id) {
		this.asset_id = asset_id;
	}
	/**
	 * @return the franchise_id
	 */
	public int getFranchise_id() {
		return franchise_id;
	}
	/**
	 * @param franchise_id the franchise_id to set
	 */
	public void setFranchise_id(int franchise_id) {
		this.franchise_id = franchise_id;
	}
	/**
	 * @return the asset_name
	 */
	public String getAsset_name() {
		return asset_name;
	}
	/**
	 * @param asset_name the asset_name to set
	 */
	public void setAsset_name(String asset_name) {
		this.asset_name = asset_name;
	}
	/**
	 * @return the balance
	 */
	public int getBalance() {
		return balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}
	/**
	 * @return the created_by
	 */
	public String getCreated_by() {
		return created_by;
	}
	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	/**
	 * @return the source_creation
	 */
	public String getSource_creation() {
		return source_creation;
	}
	/**
	 * @param source_creation the source_creation to set
	 */
	public void setSource_creation(String source_creation) {
		this.source_creation = source_creation;
	}
	/**
	 * @return the system_created_date
	 */
	public Date getSystem_created_date() {
		return system_created_date;
	}
	/**
	 * @param system_created_date the system_created_date to set
	 */
	public void setSystem_created_date(Date system_created_date) {
		this.system_created_date = system_created_date;
	}
	/**
	 * @return the is_deleted
	 */
	public Boolean getIs_deleted() {
		return is_deleted;
	}
	/**
	 * @param is_deleted the is_deleted to set
	 */
	public void setIs_deleted(Boolean is_deleted) {
		this.is_deleted = is_deleted;
	}
	/**
	 * @return the deleted_by
	 */
	public String getDeleted_by() {
		return deleted_by;
	}
	/**
	 * @param deleted_by the deleted_by to set
	 */
	public void setDeleted_by(String deleted_by) {
		this.deleted_by = deleted_by;
	}
	/**
	 * @return the deleted_date
	 */
	public Date getDeleted_date() {
		return deleted_date;
	}
	/**
	 * @param deleted_date the deleted_date to set
	 */
	public void setDeleted_date(Date deleted_date) {
		this.deleted_date = deleted_date;
	}
	/**
	 * @return the is_expired
	 */
	public Boolean getIs_expired() {
		return is_expired;
	}
	/**
	 * @param is_expired the is_expired to set
	 */
	public void setIs_expired(Boolean is_expired) {
		this.is_expired = is_expired;
	}
	@Override
	public String toString() {
		return "EscrowBook [col_id=" + col_id + ", transaction_id=" + transaction_id + ", transaction_ref_no="
				+ transaction_ref_no + ", plan_id=" + plan_id + ", amount=" + amount + ", payment_type=" + payment_type
				+ ", payment_mode=" + payment_mode + ", status=" + status + ", date_created=" + date_created
				+ ", date_modified=" + date_modified + ", driver_id=" + driver_id + ", asset_id=" + asset_id
				+ ", franchise_id=" + franchise_id + ", asset_name=" + asset_name + ", balance=" + balance
				+ ", created_by=" + created_by + ", source_creation=" + source_creation + ", system_created_date="
				+ system_created_date + ", is_deleted=" + is_deleted + ", deleted_by=" + deleted_by + ", deleted_date="
				+ deleted_date + ", is_expired=" + is_expired + "]";
	}
	public EscrowBook(int col_id, String transaction_id, String transaction_ref_no, int plan_id, int amount,
			String payment_type, String payment_mode, String status, Date date_created, Date date_modified,
			int driver_id, int asset_id, int franchise_id, String asset_name, int balance, String created_by,
			String source_creation, Date system_created_date, Boolean is_deleted, String deleted_by, Date deleted_date,
			Boolean is_expired) {
		this.col_id = col_id;
		this.transaction_id = transaction_id;
		this.transaction_ref_no = transaction_ref_no;
		this.plan_id = plan_id;
		this.amount = amount;
		this.payment_type = payment_type;
		this.payment_mode = payment_mode;
		this.status = status;
		this.date_created = date_created;
		this.date_modified = date_modified;
		this.driver_id = driver_id;
		this.asset_id = asset_id;
		this.franchise_id = franchise_id;
		this.asset_name = asset_name;
		this.balance = balance;
		this.created_by = created_by;
		this.source_creation = source_creation;
		this.system_created_date = system_created_date;
		this.is_deleted = is_deleted;
		this.deleted_by = deleted_by;
		this.deleted_date = deleted_date;
		this.is_expired = is_expired;
	}
	public EscrowBook() {
		// TODO Auto-generated constructor stub
	}
	

	
}
