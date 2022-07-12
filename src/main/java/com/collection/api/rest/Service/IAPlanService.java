package com.collection.api.rest.Service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collection.api.rest.model.IaPlan;
import com.collection.api.rest.repository.IaPlanRepository;

@Service
public class IAPlanService {

	
		private static final Logger log = LoggerFactory.getLogger(IAPlanService.class);
	
		@Autowired
		IaPlanRepository iaRepo;
		
		public List<IaPlan> showData()
		{
			try 
			{
				log.info("In IaPlan service fetching all data");
				return this.iaRepo.findAll();
			} catch (Exception e) 
			{
				log.error("Exception Occured in showData at IAPlanService={}",e);
			}
			return null;
		}
		
		
		public String saveData(IaPlan plan)
		{
			
			try 
			{
				log.info("In IaPlan service fetching all data");
				plan.setIa_plan_id(plan.getIa_plan_id());
				plan.setPlan_name(plan.getPlan_name());
				plan.setPlan_deposit_amount(plan.getPlan_deposit_amount());
				plan.setPlan_daily_basic_amount(plan.getPlan_daily_basic_amount());
				plan.setPlan_type(plan.getPlan_type());
				plan.setIs_leave_apply(plan.getIs_leave_apply());
				plan.setPayment_type(plan.getPayment_type());
				plan.setPlan_duration(plan.getPlan_duration());
				plan.setPlan_expiry_notification(plan.getPlan_expiry_notification());
				plan.setPlan_window_slide(plan.getPlan_window_slide());
				plan.setLeave_allow_count(plan.getLeave_allow_count());
				plan.setDaily_final_plan(plan.getDaily_final_plan());
				plan.setPlan_fixed_upfront(plan.getPlan_fixed_upfront());
				plan.setCity(plan.getCity());
				plan.setPlan_applicable_to(plan.getPlan_applicable_to());
				plan.setPlan_discount(plan.getPlan_discount());
				plan.setPlan_status(plan.getPlan_status());
				plan.setCreated_by(plan.getCreated_by());
				plan.setDate_created(plan.getDate_created());
				plan.setDeleted(plan.getDeleted());
				plan.setModified_by(plan.getModified_by());
				plan.setDate_modified(plan.getDate_modified());
				this.iaRepo.save(plan);
				return "Success";
			} catch (Exception e) 
			{
				log.error("Exception Occured in saveData at IAPlanService Exception={}",e);
			}
			return null;
		}
}
