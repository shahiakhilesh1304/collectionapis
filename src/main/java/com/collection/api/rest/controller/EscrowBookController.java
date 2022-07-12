package com.collection.api.rest.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.collection.api.rest.RequestResponseDTO.DateCreatedRequest;
import com.collection.api.rest.RequestResponseDTO.Date_DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.DriverIdAndDateAsRequest;
import com.collection.api.rest.RequestResponseDTO.DriverIdAsRequest;
import com.collection.api.rest.RequestResponseDTO.IdAsRequest;
import com.collection.api.rest.RequestResponseDTO.KaeKamReponseReport;
import com.collection.api.rest.RequestResponseDTO.KaeKamResponse;
import com.collection.api.rest.RequestResponseDTO.KaeRequest;
import com.collection.api.rest.RequestResponseDTO.Kae_DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.ReportRequest;
import com.collection.api.rest.RequestResponseDTO.StatusResponse;
import com.collection.api.rest.RequestResponseDTO.DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.FranchiseIdAsRequest;
import com.collection.api.rest.Service.EscrowBookService;
import com.collection.api.rest.Service.IAPlanService;
import com.collection.api.rest.model.EscrowBook;
import com.collection.api.rest.model.IaPlan;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api")
public class EscrowBookController {
	
	private static final Logger log = LoggerFactory.getLogger(EscrowBookController.class);

	
	@Autowired
	EscrowBookService esbService;
	
	@Autowired
	IAPlanService iaService;
	
	@PostMapping("/saveData")
	public ResponseEntity<StatusResponse> saveEscrowData(@RequestBody EscrowBook esbSaveData) {
		StatusResponse status = new StatusResponse();
		try {
			
			return new ResponseEntity<StatusResponse>(this.esbService.saveData(esbSaveData), HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in saveEscrowData in EscrowBookController class => {}", e);
			status.setStatus("500");
			status.setMsg("Error: Internal Server Error");
			return new ResponseEntity<StatusResponse>(status,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@PostMapping("/showall")
//	public ResponseEntity<List<EscrowBook>> showAll() {
//		try {
//			return new ResponseEntity<List<EscrowBook>>(this.esbService.getAll(), HttpStatus.OK);
//
//		} catch (Exception e) {
//			log.error("Exception occured in saveEscrowData in EscrowBookController class => {}", e);
//		}
//		return new ResponseEntity<List<EscrowBook>>(new ArrayList<>(), HttpStatus.OK);
//	}
	
//	@PostMapping("/editData")
//	public ResponseEntity<StatusResponse> editEscrowdata(@RequestBody EscrowBook esbEditData) {
//		StatusResponse status = new StatusResponse();
//		try {
//			return new ResponseEntity<StatusResponse>(this.esbService.editData(esbEditData), HttpStatus.OK);
//		} catch (Exception e) {
//			log.error("Exception occured in editEscrowdata in EscrowBookController class => {}", e);
//			status.setStatus("500");
//			status.setMsg("Error: Internal Server Error");
//			return new ResponseEntity<StatusResponse>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//	@PostMapping("/deleteData")
//	public ResponseEntity<StatusResponse> deleteEscrowData(@RequestBody IdAsRequest request) {
//		StatusResponse status = new StatusResponse();
//		try {
//			return new ResponseEntity<StatusResponse>(this.esbService.deleteData(request.getId()), HttpStatus.OK);
//		} catch (Exception e) {
//			log.error("Exception occured in deleteEscrowData in EscrowBookController class => {}", e);
//			status.setStatus("500");
//			status.setMsg("Error: Internal Server Error");
//			return new ResponseEntity<StatusResponse>(status,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}

//	@PostMapping("/searchingId")
//	public ResponseEntity<List<EscrowBook>> searchEsrcowDataWithId(@RequestBody IdAsRequest request) {
//		try {
//			return new ResponseEntity<List<EscrowBook>>(this.esbService.searchDataWithId(request.getId()), HttpStatus.OK);
//		} catch (Exception e) {
//			log.error("Exception occured in searchEsrcowDataWithId in EscrowBookController class => {}", e);
//		}
//		return new ResponseEntity<List<EscrowBook>>(new ArrayList<EscrowBook>(), HttpStatus.OK);
//	}

//	@PostMapping("/searchingDriverId")
//	public ResponseEntity<Map<String,Integer>> searchEsrcowDataWithDriverId(@RequestBody DriverIdAsRequest driver_id) {
//		try {
//			return new ResponseEntity<Map<String,Integer>>(this.esbService.searchDataWithDriverId(driver_id.getDriver_id()),
//					HttpStatus.OK);
//		} catch (Exception e) {
//			log.error("Exception occured in searchEsrcowDataWithDriverId in EscrowBookController class => {}", e);
//		}
//		return new ResponseEntity<Map<String,Integer>>(new HashMap<String,Integer>(), HttpStatus.OK);
//	}
//	
	@PostMapping("/searchingFullDriverId")
	public ResponseEntity<DriverIdResponse> searchEsrcowFullDataWithDriverId(@RequestBody DriverIdAsRequest driver_id) {
		try {
			return new ResponseEntity<DriverIdResponse>(this.esbService.searchFullDataWithDriverId(driver_id.getDriver_id()),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in searchEsrcowDataWithDriverId in EscrowBookController class => {}", e);
		}
		return new ResponseEntity<DriverIdResponse>(new DriverIdResponse(), HttpStatus.OK);
	}

	@PostMapping("/searchingDateAndDriverId")
	public ResponseEntity<Date_DriverIdResponse> searchEsrcowDriverIdandDate(@RequestBody DriverIdAndDateAsRequest request) 
	{
		try {
			Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(request.getDate());
			log.info("The value of date and id is date={}, id={}",d1,request.getDriver_id());
			return new ResponseEntity<Date_DriverIdResponse>(this.esbService.searchDataWithDriverIdandDate(request.getDriver_id(),d1),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in searchEsrcowDataWithDriverId in EscrowBookController class => {}", e);
		}
		return new ResponseEntity<Date_DriverIdResponse>(new Date_DriverIdResponse(), HttpStatus.OK);
	}

//	@PostMapping("/searchingFranchiseId")
//	public ResponseEntity<List<EscrowBook>> searchEsrcowDataWithFranchiseId(@RequestBody FranchiseIdAsRequest franchise_id) {
//		try {
//			return new ResponseEntity<List<EscrowBook>>(this.esbService.searchDataWithFrenchiseId(franchise_id.getFreanchise_id()),
//					HttpStatus.OK);
//		} catch (Exception e) {
//			log.error("Exception occured in searchEsrcowDataWithFranchiseId in EscrowBookController class => {}", e);
//		}
//		return new ResponseEntity<List<EscrowBook>>(new ArrayList<EscrowBook>(), HttpStatus.OK);
//	}

//	@PostMapping("/searchingDate")
//	public ResponseEntity<List<EscrowBook>> searchEsrcowDataWithDate(@RequestBody DateCreatedRequest date_created) {
//		try {
//			Date d1 = new SimpleDateFormat("yyyy-MM-dd").parse(date_created.getDate_created());
//			return new ResponseEntity<List<EscrowBook>>(this.esbService.searchDataWithDate(d1), HttpStatus.OK);
//		} catch (Exception e) {
//			log.error("Exception occured in searchEsrcowDataWithDate in EscrowBookController class => {}", e);
//		}
//		return new ResponseEntity<List<EscrowBook>>(new ArrayList<EscrowBook>(), HttpStatus.OK);
//	}

//	@PostMapping("/getTotalAmountCollectionPerDate")
//	public ResponseEntity<Map<String, Integer>> getDataTotalAmount() {
//		try {
//			Map<String, Integer> mapresult = this.esbService.getTotalAmountCollectionPerDate();
//			return new ResponseEntity<Map<String, Integer>>(mapresult, HttpStatus.OK);
//		} catch (Exception e) {
//			log.error("Exception occured in getDataTotalAmount in EscrowBookController class => {}", e);
//		}
//		return new ResponseEntity<Map<String, Integer>>(new HashMap<String, Integer>(), HttpStatus.OK);
//	}

	@PostMapping("/savePlan")
	public String saveDataPlan(@RequestBody IaPlan plan)
	{
		try 
		{
			this.iaService.saveData(plan);
			return "Success";
		}catch (Exception e) 
		{
			log.error("Exception while saving plan data={}",e);
		}
		return "Error";
	}

	@PostMapping("/seeData")
	public List<IaPlan> seeData()
	{
		try {
			return this.iaService.showData();
		} catch (Exception e) {
			log.error("Exception while showing plan data={}",e);
		}
		return new ArrayList<IaPlan>();
	}
	
	
	
	@PostMapping("/report")
	public List<KaeKamReponseReport> reporting()
	{
		try 
		{
			return this.esbService.getReport();
		} catch (Exception e) {
			log.error("Exception while reporting={}",e);
		}
		return new ArrayList<>();
	}
	
	
	@PostMapping("/getreport")
	public List<KaeKamResponse> reporti(@RequestBody ReportRequest report)
	{
		try 
		{
			return this.esbService.reportGet(report);
		} catch (Exception e) {
			log.error("Exception while reporting={}",e);
		}
		return new ArrayList<>();
	}
	
	@PostMapping("/collectionReport")
	public ResponseEntity<List<Kae_DriverIdResponse>> report(@RequestBody KaeRequest kae_id) {
		try {
			return new ResponseEntity<List<Kae_DriverIdResponse>>(this.esbService.collectionReport(kae_id.getKae()),HttpStatus.OK);
		} catch (Exception e) {
			log.error("Exception occured in searchEsrcowDataWithDriverId in EscrowBookController class => {}", e);
		}
		return new ResponseEntity<List<Kae_DriverIdResponse>>(new ArrayList<>(), HttpStatus.OK);
	}


}
