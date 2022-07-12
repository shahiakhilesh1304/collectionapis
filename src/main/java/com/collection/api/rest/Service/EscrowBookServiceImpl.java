package com.collection.api.rest.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import com.collection.api.rest.RequestResponseDTO.CollectionKAEKAM;
import com.collection.api.rest.RequestResponseDTO.Dailydata;
import com.collection.api.rest.RequestResponseDTO.Date_DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.KaeKamReponseReport;
import com.collection.api.rest.RequestResponseDTO.KaeKamResponse;
import com.collection.api.rest.RequestResponseDTO.KaeKamResultSet;
import com.collection.api.rest.RequestResponseDTO.Kae_DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.ReportRequest;
import com.collection.api.rest.RequestResponseDTO.StatusResponse;
import com.collection.api.rest.model.EscrowBook;
import com.collection.api.rest.model.EscrowBookMySql;
import com.collection.api.rest.model.SequenceGeneratorService;
import com.collection.api.rest.repository.EscrowBookMSRepository;
import com.collection.api.rest.repository.EscrowBookRepository;
import com.collection.api.rest.repository.IaPlanRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Service
public class EscrowBookServiceImpl implements EscrowBookService {
	// Creation of looger for this class
	private static final Logger log = LoggerFactory.getLogger(EscrowBookServiceImpl.class);

	ObjectMapper mapper = new ObjectMapper();

	// Autowiring
	@Autowired
	EscrowBookRepository escRepo;

	@Autowired
	SequenceGeneratorService escrowSeqGen;

	@Autowired
	EscrowBookMSRepository msrepo;

	@Autowired
	IaPlanRepository iaRepo;
	
	 @Autowired
	 private JdbcTemplate jdbcTemplate;

	SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");

//	@Override
//	public List<EscrowBook> getAll()
//	{
//		try {
//			return this.escRepo.findAll();
//		} catch (Exception e) 
//		{
//			log.error("Exception occured in sgetAll method in EscrowBookService Class={} ", e);
//		}
//		return null;
//	}

	public Boolean parsing(int a) {
		if (a == 0) {
			return false;
		} else {
			return true;
		}
	}

	public Boolean expiry(Date date) {
		Date today = new Date();
		String d1 = out.format(date);
		String d2 = out.format(today);
		if (d1.compareTo(d2) > 0) {
			return false;
		} else if (d1.compareTo(d2) < 0) {
			return true;
		}
		return false;
	}

	@Override
	public StatusResponse saveData(EscrowBook ecbm) {
		int id = 0;
		String planid = null;
		StatusResponse status = new StatusResponse();
		try {
			List<EscrowBook> checkDataAvailability = this.escRepo.findByDriver_Id(ecbm.getDriver_id());
			if (checkDataAvailability.size() > 0) {
				for (EscrowBook es : checkDataAvailability) {
					String d1 = out.format(es.getDate_created());
					String d2 = out.format(ecbm.getDate_created());
					if (d1.compareTo(d2) == 0) {
						status = this.editData(ecbm);
						return status;
					} else {
						planid = this.msrepo.findPlanId(ecbm.getDriver_id());
						log.info("id={},plan={}", id, planid);
						id = escrowSeqGen.generateSequence(ecbm.SEQUENCE_NAME);
						ecbm.setCol_id(id);
						ecbm.setDate_created(ecbm.getDate_created());
						ecbm.setDate_modified(new Date());
						ecbm.setSystem_created_date(new Date());
						ecbm.setDeleted_date(ecbm.getDeleted_date());
						ecbm.setTransaction_id(ecbm.getTransaction_id());
						ecbm.setTransaction_ref_no(ecbm.getTransaction_ref_no());
						ecbm.setPayment_mode(ecbm.getPayment_mode());
						ecbm.setIs_deleted(false);
						ecbm.setDeleted_date(ecbm.getDeleted_date());
						ecbm.setDeleted_by(" ");
						ecbm.setPlan_id(Integer.parseInt(planid));
						ecbm.setIs_expired(false);
						log.info("The value we are saving is  ={}", mapper.writeValueAsString(ecbm));
						this.escRepo.save(ecbm);
						status.setStatus("200");
						status.setMsg("Success : New Saved");
						return status;

					}
				}
			} else {
				log.info("fetching planid");
				planid = this.msrepo.findPlanId(ecbm.getDriver_id());
				log.info("id={},plan={}", id, planid);
				id = escrowSeqGen.generateSequence(ecbm.SEQUENCE_NAME);
				ecbm.setCol_id(id);
				ecbm.setDate_created(ecbm.getDate_created());
				ecbm.setDate_modified(new Date());
				ecbm.setSystem_created_date(new Date());
				ecbm.setDeleted_date(ecbm.getDeleted_date());
				ecbm.setTransaction_id(ecbm.getTransaction_id());
				ecbm.setTransaction_ref_no(ecbm.getTransaction_ref_no());
				ecbm.setPayment_mode(ecbm.getPayment_mode());
				ecbm.setIs_deleted(false);
				ecbm.setDeleted_date(ecbm.getDeleted_date());
				ecbm.setDeleted_by(" ");
				ecbm.setPlan_id(Integer.parseInt(planid));
				ecbm.setIs_expired(false);
				log.info("The value we are saving is  ={}", mapper.writeValueAsString(ecbm));
				this.escRepo.save(ecbm);
				status.setStatus("200");
				status.setMsg("Success : New Saved");
				return status;

			}
		} catch (Exception e) {
			log.error("Exception occured in saveData method in EscrowBookService Class={} " + e);
		}
		status.setStatus("500");
		status.setMsg("Error: Internal Server error");
		return status;
	}

	@Override
	public StatusResponse editData(EscrowBook ecbm) {
		StatusResponse status = new StatusResponse();
		try {
			// extracting the value from database (Query execution) matching with the id
			Optional<EscrowBook> checkDataAvailability = this.escRepo.findByDriver_IdData(ecbm.getDriver_id());
			if (checkDataAvailability.get() != null) {
				System.out.println("\n\nExtracted Data" + checkDataAvailability.get());
				checkDataAvailability.get().setTransaction_id(ecbm.getTransaction_id());
				checkDataAvailability.get().setTransaction_id(ecbm.getTransaction_id());
				checkDataAvailability.get().setTransaction_ref_no(ecbm.getTransaction_ref_no());
				checkDataAvailability.get().setAmount(ecbm.getAmount());
				checkDataAvailability.get().setPayment_type(ecbm.getPayment_type());
				checkDataAvailability.get().setPayment_mode(ecbm.getPayment_mode());
				checkDataAvailability.get().setStatus(ecbm.getStatus());
				checkDataAvailability.get().setDate_created(ecbm.getDate_created());
				checkDataAvailability.get().setDate_modified(new Date());
				checkDataAvailability.get().setDriver_id(ecbm.getDriver_id());
				checkDataAvailability.get().setAsset_id(ecbm.getAsset_id());
				checkDataAvailability.get().setFranchise_id(ecbm.getFranchise_id());
				checkDataAvailability.get().setBalance(ecbm.getBalance());
				checkDataAvailability.get().setAsset_name(ecbm.getAsset_name());
				checkDataAvailability.get().setCreated_by(ecbm.getCreated_by());
				checkDataAvailability.get().setSource_creation(ecbm.getSource_creation());
				checkDataAvailability.get().setSystem_created_date(ecbm.getSystem_created_date());
				checkDataAvailability.get().setIs_deleted(ecbm.getIs_deleted());
				checkDataAvailability.get().setDeleted_by(ecbm.getDeleted_by());
				checkDataAvailability.get().setDeleted_date(ecbm.getDeleted_date());
				checkDataAvailability.get().setPlan_id(ecbm.getPlan_id());
				checkDataAvailability.get().setIs_expired(ecbm.getIs_expired());
				this.escRepo.save(checkDataAvailability.get());
				status.setStatus("200");
				status.setMsg("Success : Updated");
				return status;
			} else {
				status.setStatus("400");
				status.setMsg("Error");
				return status;
			}

		} catch (Exception e) {
			log.error("Exception occured in editData method in EscrowBookService Class={} " + e);
			status.setStatus("500");
			status.setMsg("Error: Internal Server Error");
			return status;

		}
	}

//	@Override
//	public StatusResponse deleteData(int id) {
//		StatusResponse status = new StatusResponse();
//		try {
//			// extracting the value from database (Query execution) matching with the id
//			Optional<EscrowBook> checkDataAvailability = this.escRepo.findById(id);
//			if (checkDataAvailability.get() != null) {
//				this.escRepo.deleteById(id);
//				status.setStatus("200");
//				status.setMsg("Success");
//				return status;
//			} else {
//				status.setStatus("404");
//				status.setMsg("Not Found");
//				return status;
//			}
//
//		} catch (Exception e) {
//			log.error("Exception occured in deleteData method in EscrowBookService Class={}",e);
//			status.setStatus("500");
//			status.setMsg("Error: Internal Server Error");
//			return status;
//		}
//	}

//	@Override
//	public List<EscrowBook> searchDataWithId(int id) {
//		try {
//			// System.out.println(id);
//			List<EscrowBook> esbook = new ArrayList<>();
//			Optional<EscrowBook> esd = this.escRepo.findByCol_Id(id);
//			if (esd.get() != null) {
//				esbook.add(esd.get());
//				System.out.println(esbook);
//				return esbook;
//			} else {
//				return new ArrayList<>();
//			}
//		} catch (Exception e) {
//			log.error("Exception occured in deleteData method in EscrowBookService Class={} " + e);
//		}
//		return null;
//	}

//	@Override
//	public Map<String,Integer> searchDataWithDriverId(int driver_id) {
//		try {
//			// System.out.println(id);
//			List<EscrowBook> esd = this.escRepo.findByDriver_Id(driver_id);
//			Map<String,Integer> result = new HashMap<String, Integer>();
//			if (esd != null) 
//			{
//				for(EscrowBook es: esd)
//				{
//					if(result.isEmpty())
//					{
//						String d2 = out.format(es.getDate_created());
//						result.put(d2, es.getAmount());
//					}else
//					{
//						String d1 = out.format(es.getDate_created());
//						int amount = 0;
//						if(result.containsKey(d1))
//						{
//							amount = result.get(d1);
//							amount = amount + es.getAmount();
//							result.put(d1, amount);
//						}else
//						{
//							result.put(d1,es.getAmount());
//						}
//					}
//				}
//				return result;
//			} else {
//				return new HashMap<String, Integer>();
//			}
//		} catch (Exception e) {
//			log.error("Exception occured in deleteData method in EscrowBookService Class={} " + e);
//		}
//		return null;
//	}

	@Override
	public DriverIdResponse searchFullDataWithDriverId(int driver_id) {
		try {

			int total_invoice_generated = 0;
			int balance = 0;
			int total_credit = 0;
			int asset_serial_number = 0;
			int planid = 0;
			int assetid = 0;
			String drivername = "";
			String planstartdate = "0000-00-00";
			String plannname = "";
			DriverIdResponse result;
			List<EscrowBookMySql> invoice = this.msrepo.findByDriverId(driver_id);
			List<EscrowBook> collection = this.escRepo.findByDriver_Id(driver_id);
			List<Object[]> plandetail = this.msrepo.getPlanDetails(driver_id);
			if (plandetail.size() > 0) {
				for (Object[] ob : plandetail) {
					try {
						planid = Integer.parseInt(ob[3].toString());
					}catch(NumberFormatException e)
					{
						planid = 0;
					}
					drivername = ob[1].toString();
					try {
						planstartdate = ob[2].toString();
					}catch(NullPointerException e)
					{
						planstartdate = "0000-00-00";
					}
					plannname = ob[0].toString();
				}
			}
			if (collection != null) {
				result = new DriverIdResponse();
				for (EscrowBookMySql inv : invoice) 
				{
					assetid = inv.getAsset_id();
					try {
						total_invoice_generated += Math.abs(Integer.parseInt(inv.getAmount()));
			        } catch (NumberFormatException e) {
			        	log.info("Number Format Exception occured the amount value is {}",inv.getAmount());
			        }
					asset_serial_number = inv.getAsset_id();
				}
				for (EscrowBook credit : collection) {
					assetid = credit.getAsset_id();
					total_credit += Math.abs(credit.getAmount());
					asset_serial_number = credit.getAsset_id();
				}
				balance = (Math.abs(total_credit) - Math.abs(total_invoice_generated));
				log.info("Value for balance is balance={}, total cedit={} total invoice={}", balance, total_credit,total_invoice_generated);
				result.setDriver_name(drivername);
				result.setPlan_id(planid);
				result.setPlan_name(plannname);
				result.setPlan_startdate(planstartdate);
				result.setTotal_invoice_generated(total_invoice_generated);
				result.setTotal_credit(total_credit);
				result.setBalance(balance);
				result.setAsset_serial_number(asset_serial_number);
				return result;

			} else if (invoice != null) {
				result = new DriverIdResponse();
				for (EscrowBookMySql inv : invoice) {
					assetid = inv.getAsset_id();
					try {
						total_invoice_generated += Math.abs(Integer.parseInt(inv.getAmount()));
			        } catch (NumberFormatException e) {
			        	log.info("Number Format Exception occured the amount value is {}",inv.getAmount());
			        }
					asset_serial_number = inv.getAsset_id();
				}
				total_credit = 0;
				try
				{
					balance = (Math.abs(total_credit) - Math.abs(total_invoice_generated));
				}catch(ArithmeticException e)
				{
					log.info("Arithmatic Exception occured while computing balance with total_credit={}, total_invoice_generated={}",total_credit,total_invoice_generated);
				}
				log.info("Value for balance is balance={}, total cedit={} total invoice={}", balance, total_credit,
						total_invoice_generated);
				result.setDriver_name(drivername);
				result.setPlan_id(planid);
				result.setPlan_name(plannname);
				result.setPlan_startdate(planstartdate);
				result.setTotal_invoice_generated(total_invoice_generated);
				result.setTotal_credit(total_credit);
				result.setBalance(balance);
				result.setAsset_serial_number(asset_serial_number);
				return result;
			} else {
				return new DriverIdResponse();
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occured in searchFullDataWithDriverId method in EscrowBookService Class={} " + e);
		}
		return null;
	}

//	@Override
//	public List<EscrowBook> searchDataWithFrenchiseId(int franchise_id) {
//		try {
//			// System.out.println(id);
//			List<EscrowBook> esd = this.escRepo.findByFerchise_Id(franchise_id);
//			if (esd != null) {
//				return esd;
//			} else {
//				return new ArrayList<>();
//			}
//		} catch (Exception e) {
//			log.error("Exception occured in deleteData method in EscrowBookService Class={} " + e);
//		}
//		return null;
//	}

//	@Override
//	public List<EscrowBook> searchDataWithDate(Date date_creat) {
//		try {
//			List<EscrowBook> esbook = this.escRepo.findByDate_Created(date_creat);
//			if (esbook != null) 
//			{
//				String d2 = out.format(date_creat);
//				List<EscrowBook> FilteredContent = esbook.stream().filter(es -> (out.format(es.getDate_created())).equals(d2)).collect(Collectors.toList());
//				return FilteredContent;
//			} else {
//				System.out.println("Not Found");
//			}
//		} catch (Exception e) {
//			log.error("Exception occured in searchDataWithDate method in EscrowBookService Class={} ",e);
//		}
//		return null;
//	}
//
//	@Override
//	public Map<String,Integer> getTotalAmountCollectionPerDate() {
//		try 
//		{
//			List<EscrowBook> data = this.escRepo.findAll();
//			Map<String,Integer> mapdata = new HashMap<String, Integer>();
//			if(data != null)
//			{
//				for(EscrowBook es: data)
//				{
//					if(mapdata.isEmpty())
//					{
//						String d2 = out.format(es.getDate_created());
//						mapdata.put(d2, es.getAmount());
//					}else
//					{
//						String d1 = out.format(es.getDate_created());
//						int amount = 0;
//						if(mapdata.containsKey(d1))
//						{
//							amount = mapdata.get(d1);
//							amount = amount + es.getAmount();
//							mapdata.put(d1, amount);
//						}else
//						{
//							mapdata.put(d1,es.getAmount());
//						}
//					}
//				}
//				return mapdata;
//			}else
//			{
//				return new HashMap<String, Integer>();
//			}
//		} catch (Exception e) {
//			log.error("Exception occured in getTotalAmountCollectionPerDate method in EscrowBookService Class={} ",e);
//		}
//		return null;
//	}

	@Override
	public Date_DriverIdResponse searchDataWithDriverIdandDate(int driver_id, Date date) {
		try {
			log.info("The value of date and id is date={}, id={} accepted in service", date, driver_id);
			Date_DriverIdResponse result = new Date_DriverIdResponse();
			Date newdate;
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.DATE, 1); // minus number would decrement the days
			newdate = cal.getTime();
			Dailydata data;
			List<EscrowBook> todaycollection = new ArrayList<>();
			List<EscrowBook> esbook = this.escRepo.findByDriverIdAndDate_Created(driver_id, newdate);
			log.info("The value of date and id  Mongo is date={}, id={} accepted in service esbook={}",
					mapper.writeValueAsString(esbook));
			List<Dailydata> amoun = new ArrayList<>();
			if (esbook.size() > 0) {
				Map<String, Integer> mapdata = new HashMap<String, Integer>();
				Map<String, Integer> mapdatabalance = new HashMap<String, Integer>();
				for (EscrowBook es : esbook) {
					if ((out.format(date)).equals(out.format(es.getDate_created()))) {
						EscrowBook datas = new EscrowBook();
						datas.setCol_id(es.getCol_id());
						datas.setAmount(es.getAmount());
						datas.setAsset_id(es.getAsset_id());
						datas.setAsset_name(es.getAsset_name());
						datas.setBalance(es.getBalance());
						datas.setCreated_by(es.getCreated_by());
						datas.setDate_created(es.getDate_created());
						datas.setDate_modified(es.getDate_modified());
						datas.setDeleted_by(es.getDeleted_by());
						datas.setDeleted_date(es.getDeleted_date());
						datas.setDriver_id(es.getDriver_id());
						datas.setFranchise_id(es.getFranchise_id());
						datas.setIs_deleted(es.getIs_deleted());
						datas.setIs_expired(false);
						datas.setTransaction_id(es.getTransaction_id());
						datas.setTransaction_ref_no(es.getTransaction_ref_no());
						datas.setPlan_id(Integer.parseInt(this.msrepo.findPlanId(es.getDriver_id())));
						datas.setPayment_mode(es.getPayment_mode());
						datas.setPayment_type(es.getPayment_type());
						datas.setStatus(es.getStatus());
						datas.setSystem_created_date(es.getSystem_created_date());
						datas.setSource_creation(es.getSource_creation());
						todaycollection.add(datas);
					}
					String d2 = out.format(es.getDate_created());
					if (!mapdata.containsKey(d2)) {
						for (EscrowBook esall : esbook) {
							String d3 = out.format(esall.getDate_created());
							if (d2.equals(d3)) {
								int amount = 0;
								int balance = 0;
								if (mapdata.containsKey(d2)) {
									// working on amount
									amount = mapdata.get(d2) + esall.getAmount();
									mapdata.put(d2, amount);
									if (mapdatabalance.containsKey(d2)) {
										// working on balance
										balance = mapdatabalance.get(d2) + esall.getBalance();
										mapdatabalance.put(d2, balance);
									} else {
										mapdatabalance.put(d2, esall.getBalance());
									}
								} else {
									mapdata.put(d2, esall.getAmount());
									if (mapdatabalance.containsKey(d2)) {
										// working on balance
										balance = mapdatabalance.get(d2) + esall.getBalance();
										mapdatabalance.put(d2, balance);
									} else {
										mapdatabalance.put(d2, esall.getBalance());
									}
								}
							}
						}
					}

				}
				// Values computed
				for (Map.Entry<String, Integer> set : mapdata.entrySet()) {
					data = new Dailydata();
					data.setDate(set.getKey());
					data.setTotalAmount(set.getValue());
					for (Map.Entry<String, Integer> set2 : mapdatabalance.entrySet()) {
						if (data.getDate().equals(set2.getKey())) {
							data.setTotalBalance(set2.getValue());
						}
					}
					amoun.add(data);

				}
				result.setDailyGross(amoun);
				result.setDateData(todaycollection);

				return result;

			} else {
				result = new Date_DriverIdResponse();
				return result;
			}

		} catch (Exception e) {
			log.error("Exception occured in searchDataWithDriverIdandDate at EscrowBookServiceImpl={}", e);
		}
		return null;
	}

	@Override
	public List<KaeKamReponseReport> getReport() {

		try {
			List<KaeKamReponseReport> finalReport = new ArrayList<>();
			List<CollectionKAEKAM> collectionresult = new ArrayList<>();
			KaeKamReponseReport report = new KaeKamReponseReport();
			CollectionKAEKAM collected = new CollectionKAEKAM();
			List<Object[]> kaekamInfo = this.msrepo.findKaeKamReporting();
			int drive1 = 0, drive2 = 0;
			if (kaekamInfo.size() > 0) {

				for (Object[] ob : kaekamInfo) 
				{
					String d1 = ob[7].toString();
					Boolean numberExp = true;
					try 
					{
						Integer.parseInt(ob[4].toString());
					}catch(NumberFormatException e)
					{
						numberExp = false;
					}
					if(numberExp)
					{
						drive1 = Integer.parseInt(ob[4].toString());
						List<EscrowBook> collection = this.escRepo.findByDriver_Id(Integer.parseInt(ob[4].toString()));
	//					log.info("Mongo Data={}, driver id={}", mapper.writeValueAsString(collection),Integer.parseInt(ob[4].toString()));
						if (drive1 != drive2) {
							collectionresult = new ArrayList<>();
						}
						if (collection.size() > 0) {
		
							int col = 0;
							for (EscrowBook es : collection) {
								if (d1.compareTo(out.format(es.getDate_created())) == 0) {
									col += es.getAmount();
								}
							}
							collected = new CollectionKAEKAM();
							collected.setInvoice(ob[6].toString());
							collected.setDate(d1);
							collected.setCollection(String.valueOf(col));
							collectionresult.add(collected);
						} else {
							collected = new CollectionKAEKAM();
							collected.setInvoice(ob[6].toString());
							collected.setDate(d1);
							collected.setCollection("0");
							collectionresult.add(collected);
						}
					}else
					{
						drive1 = 0;
						List<EscrowBook> collection = this.escRepo.findByDriver_Id(Integer.parseInt(ob[4].toString()));
						if (drive1 != drive2) {
							collectionresult = new ArrayList<>();
						}
						if (collection.size() > 0) {
		
							int col = 0;
							for (EscrowBook es : collection) {
								if (d1.compareTo(out.format(es.getDate_created())) == 0) {
									col += es.getAmount();
								}
							}
							collected = new CollectionKAEKAM();
							collected.setInvoice(ob[6].toString());
							collected.setDate(d1);
							collected.setCollection(String.valueOf(col));
							collectionresult.add(collected);
						} else {
							collected = new CollectionKAEKAM();
							collected.setInvoice(ob[6].toString());
							collected.setDate(d1);
							collected.setCollection("0");
							collectionresult.add(collected);
						}
					}
					report = new KaeKamReponseReport();
					report.setKam(ob[0].toString());
					report.setKae(ob[1].toString());
					report.setFranchise(ob[2].toString());
					report.setDriver_name(ob[3].toString());
					report.setCollection(collectionresult);
					finalReport.add(report);
					try
					{
						drive2 = Integer.parseInt(ob[4].toString());
					}catch(NumberFormatException e)
					{
						log.info("Number format exception the db value of driver id is={}",ob[4].toString());
					}
				}
				return finalReport;
			}
		} catch (Exception e) {
			log.error("Exception occured in getReport at EscrowBookServiceImpl={}", e);
		}
		return null;
	}

	@Override
	public List<KaeKamResponse> reportGet(ReportRequest request) {
		try {
			String whereClause = "SELECT "
					+ "e.name AS kam,"
					+ "d.name AS kae, "
					+ "c.name AS franchise,"
					+ "b.name AS NAME, "
					+ "a.driver_id AS driver_id,"
					+ "a.payment_type AS payment_type,"
					+ "a.amount AS amount, "
					+ "DATE(a.date_created) AS DATE, "
					+ "g.plan_name AS planname, "
					+ "g.plan_deposit_amount AS plandepositamount, "
					+ "IFNULL(if(ia_leave.id IS NOT NULL,( SELECT if(ia_leave.id IS NOT NULL,'YES','') AS leavestatus "
					+ "FROM ia_leave "
					+ "WHERE a.date_created BETWEEN ia_leave.leave_fromdate AND ia_leave.leave_todate AND user_id = a.driver_id),'NO'),'NO') AS leave_status, "
					+ "h.asset_name AS assetname, "
					+ "if(i.ticket_status = 'Plan On Hold', 'YES','NO') AS ticketstatus, "
					+ "IFNULL(CAST(i.created AS CHAR), '0000-00-00') AS datecreated, "
					+ "IFNULL(CAST(i.close_date AS CHAR),'0000-00-00') AS closingdate, "
					+ " ia_serial_number.serial_no AS srno "
					+ "FROM escrow_book a "
					+ "JOIN ia_users b ON b.ia_users_id = a.driver_id "
					+ "JOIN ia_users c ON c.ia_users_id = b.franchise_id "
					+ "JOIN ia_users d ON d.ia_users_id = c.user_report_to "
					+ "JOIN ia_users e ON e.ia_users_id = c.assigned_kam "
					+ "JOIN ia_assigned_plan f ON a.driver_id = f.driver_id "
					+ "JOIN ia_plan g ON f.plan_id = g.ia_plan_id "
					+ "JOIN ia_assets h ON a.driver_id = h.driver_id "
					+ "LEFT JOIN ia_ticket i ON a.driver_id = i.user_id "
					+ "LEFT JOIN ia_leave ON ia_leave.user_id = a.driver_id "
					+ "JOIN ia_assets ON ia_assets.driver_id = a.driver_id "
					+ "JOIN serialNo_allocation_franchise ON serialNo_allocation_franchise.id = ia_assets.battery_inventory_id "
					+ "JOIN ia_serial_number  ON serialNo_allocation_franchise.serial_number = ia_serial_number.serial_id "
					+ "WHERE a.is_deleted = 0 ";
			if(request.getYyyyMM() != null && !request.getYyyyMM().equals(""))
			{
				String year = request.getYyyyMM().split("-")[0];
				String month = request.getYyyyMM().split("-")[1];	
				whereClause = whereClause + "and YEAR(a.date_created) ='"+year+"' and MONTH(a.date_created) = '"+month+"' ";
			}
			if(request.getDriver_id() != null && !request.getDriver_id().equals(""))
			{
				whereClause = whereClause + "and a.driver_id = '"+request.getDriver_id()+"' ";
			}
			if(request.getBwDates() == null && request.getYyyyMM() == null && 
					request.getKam() == null && request.getKae() == null && 
					request.getFranchise() == null && request.getDriver_id() == null && 
					request.getYyyyMM().equals("") && request.getKam().equals("") && request.getKae().equals("") && 
					request.getFranchise().equals("") && request.getDriver_id().equals("") && request.getBwDates().equals(""))
			{
				String dateToday = out.format(new Date());
				String year = dateToday.split("-")[0];
				String month = dateToday.split("-")[1];
				whereClause = whereClause + " YEAR(a.date_created) = '"+year+"' and MONTH(a.date_created) = '"+month+"' ";
			}
			if(request.getBwDates() != null && !request.getBwDates().equals(""))
			{
				whereClause = whereClause + " and a.date_created BETWEEN '"+request.getBwDates().split("#")[0]+"' and '"+request.getBwDates().split("#")[1]+"' ";
			}
			if(request.getKae() != null && !request.getKae().equals(""))
			{
				whereClause = whereClause + " and d.role_id = '4' and d.ia_users_id = '"+request.getKae()+"' ";
			}
			if(request.getKam() != null && !request.getKam().equals(""))
			{
				whereClause = whereClause + " and e.role_id = '7' and e.ia_users_id = '"+request.getKam()+"' ";
			}
			if(request.getFranchise() != null && !request.getFranchise().equals(""))
			{
				whereClause = whereClause + " and c.role_id = '2' and c.ia_users_id = '"+request.getFranchise()+"' ";
			}
			
			whereClause = whereClause + " GROUP BY a.id order BY DATE";
			
			log.info("The executable query is  => {}",whereClause);
	    	List<KaeKamResultSet> kaekamInfo = jdbcTemplate.query(whereClause,BeanPropertyRowMapper.newInstance(KaeKamResultSet.class));	
			Map<Integer, Integer> mapdriver = new HashMap<>();
			List<KaeKamResponse> finalReport = new ArrayList<>();
			KaeKamResponse report = new KaeKamResponse();
			int drive1 = 0;
			if (kaekamInfo.size() > 0) 
			{	
				for (KaeKamResultSet ob : kaekamInfo) 
				{
					try {
						drive1 = Integer.parseInt(ob.getDriver_id());
					}catch(NumberFormatException e)
					{
						log.info("Number format exception = {}",ob.getDriver_id());
					}
					if (!mapdriver.containsKey(drive1)) {
						List<EscrowBook> collection = this.escRepo.findByDriver_Id(Integer.parseInt(ob.getDriver_id()));
						if (collection.size() > 0) {
							for (EscrowBook es : collection) 
							{
								report = new KaeKamResponse();
								report.setKam(ob.getKam());
								report.setKae(ob.getKae());
								report.setFranchise(ob.getFranchise());
								report.setDriver_name(ob.getName());
								report.setDriver_id(String.valueOf(es.getDriver_id()));
								report.setPayment_type(es.getPayment_type());
								report.setAmount(String.valueOf(es.getAmount()));
								report.setDate_created(out.format(es.getDate_created()));
								report.setPlanname(ob.getPlanname());
								report.setPlandepositamount(ob.getPlandepositamount());
								report.setSerialnumber(ob.getSrno());
								report.setLeaveStatus(ob.getLeave_status());
								report.setTicketstatus(ob.getTicketstatus());
								report.setOpendate(ob.getDatecreated());
								report.setClosedate(ob.getClosingdate());
								finalReport.add(report);

								report = new KaeKamResponse();
								report.setKam(ob.getKam());
								report.setKae(ob.getKae());
								report.setFranchise(ob.getFranchise());
								report.setDriver_name(ob.getName());
								report.setDriver_id(ob.getDriver_id());
								report.setPayment_type(ob.getPayment_type());
								report.setAmount(String.valueOf(ob.getAmount()));
								report.setDate_created(ob.getDate());
								report.setPlanname(ob.getPlanname());
								report.setPlandepositamount(ob.getPlandepositamount());
								report.setSerialnumber(ob.getSrno());
								report.setLeaveStatus(ob.getLeave_status());
								report.setTicketstatus(ob.getTicketstatus());
								report.setOpendate(ob.getDatecreated());
								report.setClosedate(ob.getClosingdate());
								finalReport.add(report);
								mapdriver.put(Integer.parseInt(ob.getDriver_id()), 1);
							}
						}else 
						{
							report = new KaeKamResponse();
							report.setKam(ob.getKam());
							report.setKae(ob.getKae());
							report.setFranchise(ob.getFranchise());
							report.setDriver_name(ob.getName());
							report.setDriver_id(ob.getDriver_id());
							report.setPayment_type(ob.getPayment_type());
							report.setAmount(String.valueOf(ob.getAmount()));
							report.setDate_created(ob.getDate());
							report.setPlanname(ob.getPlanname());
							report.setPlandepositamount(ob.getPlandepositamount());
							report.setSerialnumber(ob.getSrno());
							report.setLeaveStatus(ob.getLeave_status());
							report.setTicketstatus(ob.getTicketstatus());
							report.setOpendate(ob.getDatecreated());
							report.setClosedate(ob.getClosingdate());
							finalReport.add(report);
						}
					} else {
						report = new KaeKamResponse();
						report.setKam(ob.getKam());
						report.setKae(ob.getKae());
						report.setFranchise(ob.getFranchise());
						report.setDriver_name(ob.getName());
						report.setDriver_id(ob.getDriver_id());
						report.setPayment_type(ob.getPayment_type());
						report.setAmount(String.valueOf(ob.getAmount()));
						report.setDate_created(ob.getDate());
						report.setPlanname(ob.getPlanname());
						report.setPlandepositamount(ob.getPlandepositamount());
						report.setSerialnumber(ob.getSrno());
						report.setLeaveStatus(ob.getLeave_status());
						report.setTicketstatus(ob.getTicketstatus());
						report.setOpendate(ob.getDatecreated());
						report.setClosedate(ob.getClosingdate());
						finalReport.add(report);

					}

				}
				log.info("Return");
				System.out.println(mapdriver);
				return finalReport;
			}
			else
			{
				report = new KaeKamResponse();
				finalReport.add(report);
				return finalReport;
			}

		} catch (Exception e) {
			log.error("Exception occured in getReport at EscrowBookServiceImpl={}", e);
		}
		return null;
	}

	@Override
	public List<Kae_DriverIdResponse> collectionReport(int kae_id) {
		try 
		{
			int total_invoice_generated = 0;
			int balance = 0;
			int total_credit = 0;
			int asset_serial_number = 0;
			int planid = 0;
			String mobileno = "";
			String drivername = "";
			String planstartdate = null;
			String plannname = "";
			Kae_DriverIdResponse result;
			List<Kae_DriverIdResponse> finalresult = new ArrayList<>();
			List<Object[]> detailbykae = this.msrepo.findByKae(kae_id);
			log.info("Found by Kae={}",mapper.writeValueAsString(detailbykae));
			if (detailbykae.size() > 0)
			{
				for (Object[] ob : detailbykae) {
					
					int driver_id = Integer.parseInt(ob[0].toString());
					String driver = ob[0].toString();
					String franchisename = ob[3].toString();
					result = new Kae_DriverIdResponse();
					
					List<EscrowBookMySql> invoice = this.msrepo.findByDriverId(driver_id);
					List<EscrowBook> collection = this.escRepo.findByDriver_Id(driver_id);
					List<Object[]> plandetail = this.msrepo.getPlanDetails(driver_id);
					if (plandetail.size() > 0) 
					{
						log.info("Found by Mongo driver_id={}", mapper.writeValueAsString(plandetail));
						for (Object[] ob1 : plandetail) 
						{
							planid = Integer.parseInt(ob1[3].toString());
							drivername = ob1[1].toString();
							if(ob1[2] != null)
							{
								planstartdate = ob1[2].toString();
							}else
							{
								planstartdate = "";
							}
							plannname = ob1[0].toString();
							mobileno = ob1[4].toString();
						}
					}
					// log.info("EscrowBook id data={}",mapper.writeValueAsString(invoice));
					if (collection != null) {
						result = new Kae_DriverIdResponse();
						if(invoice != null)
						{
							for (EscrowBookMySql inv : invoice) {
								Boolean isNumeric = true;
								try {
						            Integer.parseInt(inv.getAmount());
						        } catch (NumberFormatException e) {
						            isNumeric = false;
						        }
								if(isNumeric)
								{
									total_invoice_generated += Math.abs(Integer.parseInt(inv.getAmount()));
								}
								asset_serial_number = inv.getAsset_id();
							}
						}
						String max = "0000-00-00";
						for (EscrowBook credit : collection) 
						{
							total_credit += Math.abs(credit.getAmount());
							asset_serial_number = credit.getAsset_id();
							String maxdate = out.format(credit.getDate_created());
							if (maxdate.compareTo(max) > 0) 
							{
								max = maxdate;
							}
						}
						balance = (Math.abs(total_credit) - Math.abs(total_invoice_generated));
						log.info("Value for balance is balance={}, total cedit={} total invoice={}", balance,
								total_credit, total_invoice_generated);
						result.setDriver_id(driver);
						result.setDriver_name(drivername);
						result.setPlan_id(planid);
						result.setPlan_name(plannname);
						result.setPlan_startdate(planstartdate);
						result.setTotal_invoice_generated(total_invoice_generated);
						result.setTotal_credit(total_credit);
						total_credit = 0;
						result.setBalance(balance);
						result.setAsset_serial_number(asset_serial_number);
						result.setMobileNumber(mobileno);
						result.setLast_collection_date(max);
						result.setFranchise_name(franchisename);
						finalresult.add(result);
					} else if (invoice != null) {
						result = new Kae_DriverIdResponse();
						for (EscrowBookMySql inv : invoice) {
							log.info("Amount is ={}",inv.getAmount());
							Boolean isNumeric = true;
							try {
					            Integer num = Integer.parseInt(inv.getAmount());
					        } catch (NumberFormatException e) {
					            isNumeric = false;
					        }
							if(isNumeric)
							{
								total_invoice_generated += Math.abs(Integer.parseInt(inv.getAmount()));
							}
							asset_serial_number = inv.getAsset_id();
						}
						total_credit = 0;
						balance = (Math.abs(total_credit) - Math.abs(total_invoice_generated));
						log.info("Value for balance is balance={}, total cedit={} total invoice={}", balance,total_credit, total_invoice_generated);
						result.setDriver_name(drivername);
						result.setPlan_id(planid);
						result.setPlan_name(plannname);
						result.setPlan_startdate(planstartdate);
						result.setTotal_invoice_generated(total_invoice_generated);
						result.setTotal_credit(total_credit);
						result.setBalance(balance);
						result.setAsset_serial_number(asset_serial_number);
						result.setMobileNumber(mobileno);
						result.setLast_collection_date("There is no collection");
						result.setFranchise_name(franchisename);
						finalresult.add(result);
					} else {
						finalresult.add(result);
					}
				}
				return finalresult;
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Exception occured in searchFullDataWithDriverId method in EscrowBookService Class={} " + e);
		}
		return null;
	}

}
