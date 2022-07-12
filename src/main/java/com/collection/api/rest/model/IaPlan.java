package com.collection.api.rest.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ia_plan")
public class IaPlan 
{
	@Transient
	public static final String SEQUENCE_NAME = "IaPlan_sequence";
	
	@Id
	private String _id;
	private int ia_plan_id;
	private String plan_name;
	private String plan_deposit_amount;
	private String plan_daily_basic_amount;
	private String plan_type;
	private String is_leave_apply;
	private String payment_type;
	private String plan_duration;
	private String plan_expiry_notification;
	private String plan_window_slide;
	private String leave_allow_count;
	private String daily_final_plan;
	private String plan_fixed_upfront;
	private String city;
	private String plan_applicable_to;
	private String plan_discount;
	private String plan_status;
	private int created_by;
	private Date date_created;
	private Boolean deleted;
	private int modified_by;
	private Date date_modified;
	/**
	 * @return the ia_plan_id
	 */
	public int getIa_plan_id() {
		return ia_plan_id;
	}
	/**
	 * @param ia_plan_id the ia_plan_id to set
	 */
	public void setIa_plan_id(int ia_plan_id) {
		this.ia_plan_id = ia_plan_id;
	}
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
	 * @return the plan_deposit_amount
	 */
	public String getPlan_deposit_amount() {
		return plan_deposit_amount;
	}
	/**
	 * @param plan_deposit_amount the plan_deposit_amount to set
	 */
	public void setPlan_deposit_amount(String plan_deposit_amount) {
		this.plan_deposit_amount = plan_deposit_amount;
	}
	/**
	 * @return the plan_daily_basic_amount
	 */
	public String getPlan_daily_basic_amount() {
		return plan_daily_basic_amount;
	}
	/**
	 * @param plan_daily_basic_amount the plan_daily_basic_amount to set
	 */
	public void setPlan_daily_basic_amount(String plan_daily_basic_amount) {
		this.plan_daily_basic_amount = plan_daily_basic_amount;
	}
	/**
	 * @return the plan_type
	 */
	public String getPlan_type() {
		return plan_type;
	}
	/**
	 * @param plan_type the plan_type to set
	 */
	public void setPlan_type(String plan_type) {
		this.plan_type = plan_type;
	}
	/**
	 * @return the is_leave_apply
	 */
	public String getIs_leave_apply() {
		return is_leave_apply;
	}
	/**
	 * @param is_leave_apply the is_leave_apply to set
	 */
	public void setIs_leave_apply(String is_leave_apply) {
		this.is_leave_apply = is_leave_apply;
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
	 * @return the plan_duration
	 */
	public String getPlan_duration() {
		return plan_duration;
	}
	/**
	 * @param plan_duration the plan_duration to set
	 */
	public void setPlan_duration(String plan_duration) {
		this.plan_duration = plan_duration;
	}
	/**
	 * @return the plan_expiry_notification
	 */
	public String getPlan_expiry_notification() {
		return plan_expiry_notification;
	}
	/**
	 * @param plan_expiry_notification the plan_expiry_notification to set
	 */
	public void setPlan_expiry_notification(String plan_expiry_notification) {
		this.plan_expiry_notification = plan_expiry_notification;
	}
	/**
	 * @return the plan_window_slide
	 */
	public String getPlan_window_slide() {
		return plan_window_slide;
	}
	/**
	 * @param plan_window_slide the plan_window_slide to set
	 */
	public void setPlan_window_slide(String plan_window_slide) {
		this.plan_window_slide = plan_window_slide;
	}
	/**
	 * @return the leave_allow_count
	 */
	public String getLeave_allow_count() {
		return leave_allow_count;
	}
	/**
	 * @param leave_allow_count the leave_allow_count to set
	 */
	public void setLeave_allow_count(String leave_allow_count) {
		this.leave_allow_count = leave_allow_count;
	}
	/**
	 * @return the daily_final_plan
	 */
	public String getDaily_final_plan() {
		return daily_final_plan;
	}
	/**
	 * @param daily_final_plan the daily_final_plan to set
	 */
	public void setDaily_final_plan(String daily_final_plan) {
		this.daily_final_plan = daily_final_plan;
	}
	/**
	 * @return the plan_fixed_upfront
	 */
	public String getPlan_fixed_upfront() {
		return plan_fixed_upfront;
	}
	/**
	 * @param plan_fixed_upfront the plan_fixed_upfront to set
	 */
	public void setPlan_fixed_upfront(String plan_fixed_upfront) {
		this.plan_fixed_upfront = plan_fixed_upfront;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the plan_applicable_to
	 */
	public String getPlan_applicable_to() {
		return plan_applicable_to;
	}
	/**
	 * @param plan_applicable_to the plan_applicable_to to set
	 */
	public void setPlan_applicable_to(String plan_applicable_to) {
		this.plan_applicable_to = plan_applicable_to;
	}
	/**
	 * @return the plan_discount
	 */
	public String getPlan_discount() {
		return plan_discount;
	}
	/**
	 * @param plan_discount the plan_discount to set
	 */
	public void setPlan_discount(String plan_discount) {
		this.plan_discount = plan_discount;
	}
	/**
	 * @return the plan_status
	 */
	public String getPlan_status() {
		return plan_status;
	}
	/**
	 * @param plan_status the plan_status to set
	 */
	public void setPlan_status(String plan_status) {
		this.plan_status = plan_status;
	}
	/**
	 * @return the created_by
	 */
	public int getCreated_by() {
		return created_by;
	}
	/**
	 * @param created_by the created_by to set
	 */
	public void setCreated_by(int created_by) {
		this.created_by = created_by;
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
	 * @return the deleted
	 */
	public Boolean getDeleted() {
		return deleted;
	}
	/**
	 * @param deleted the deleted to set
	 */
	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}
	/**
	 * @return the modified_by
	 */
	public int getModified_by() {
		return modified_by;
	}
	/**
	 * @param modified_by the modified_by to set
	 */
	public void setModified_by(int modified_by) {
		this.modified_by = modified_by;
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
	public IaPlan(int ia_plan_id, String plan_name, String plan_deposit_amount, String plan_daily_basic_amount,
			String plan_type, String is_leave_apply, String payment_type, String plan_duration,
			String plan_expiry_notification, String plan_window_slide, String leave_allow_count,
			String daily_final_plan, String plan_fixed_upfront, String city, String plan_applicable_to,
			String plan_discount, String plan_status, int created_by, Date date_created, Boolean deleted,
			int modified_by, Date date_modified) {
		this.ia_plan_id = ia_plan_id;
		this.plan_name = plan_name;
		this.plan_deposit_amount = plan_deposit_amount;
		this.plan_daily_basic_amount = plan_daily_basic_amount;
		this.plan_type = plan_type;
		this.is_leave_apply = is_leave_apply;
		this.payment_type = payment_type;
		this.plan_duration = plan_duration;
		this.plan_expiry_notification = plan_expiry_notification;
		this.plan_window_slide = plan_window_slide;
		this.leave_allow_count = leave_allow_count;
		this.daily_final_plan = daily_final_plan;
		this.plan_fixed_upfront = plan_fixed_upfront;
		this.city = city;
		this.plan_applicable_to = plan_applicable_to;
		this.plan_discount = plan_discount;
		this.plan_status = plan_status;
		this.created_by = created_by;
		this.date_created = date_created;
		this.deleted = deleted;
		this.modified_by = modified_by;
		this.date_modified = date_modified;
	}
	public IaPlan() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "IaPlan [ia_plan_id=" + ia_plan_id + ", plan_name=" + plan_name + ", plan_deposit_amount="
				+ plan_deposit_amount + ", plan_daily_basic_amount=" + plan_daily_basic_amount + ", plan_type="
				+ plan_type + ", is_leave_apply=" + is_leave_apply + ", payment_type=" + payment_type
				+ ", plan_duration=" + plan_duration + ", plan_expiry_notification=" + plan_expiry_notification
				+ ", plan_window_slide=" + plan_window_slide + ", leave_allow_count=" + leave_allow_count
				+ ", daily_final_plan=" + daily_final_plan + ", plan_fixed_upfront=" + plan_fixed_upfront + ", city="
				+ city + ", plan_applicable_to=" + plan_applicable_to + ", plan_discount=" + plan_discount
				+ ", plan_status=" + plan_status + ", created_by=" + created_by + ", date_created=" + date_created
				+ ", deleted=" + deleted + ", modified_by=" + modified_by + ", date_modified=" + date_modified + "]";
	}
	
}