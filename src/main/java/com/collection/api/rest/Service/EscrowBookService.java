package com.collection.api.rest.Service;


//Imports
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.collection.api.rest.RequestResponseDTO.Date_DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.KaeKamReponseReport;
import com.collection.api.rest.RequestResponseDTO.KaeKamResponse;
import com.collection.api.rest.RequestResponseDTO.Kae_DriverIdResponse;
import com.collection.api.rest.RequestResponseDTO.ReportRequest;
import com.collection.api.rest.RequestResponseDTO.StatusResponse;
import com.collection.api.rest.model.EscrowBook;



@Service
public interface EscrowBookService 
{
	

	public StatusResponse saveData(EscrowBook ecbm);
	
	//List<EscrowBook> getAll();
	
	public StatusResponse editData(EscrowBook ecbm);

	//public StatusResponse  deleteData(int id);

//	List<EscrowBook> searchDataWithId(int id);

//	Map<String,Integer> searchDataWithDriverId(int driver_id);

	DriverIdResponse searchFullDataWithDriverId(int driver_id);

//	List<EscrowBook> searchDataWithFrenchiseId(int frenchise_id);

//	List<EscrowBook> searchDataWithDate(Date date_created);

	Date_DriverIdResponse searchDataWithDriverIdandDate(int driver_id,Date date);

//	Map<String,Integer> getTotalAmountCollectionPerDate();
	
	List<KaeKamReponseReport> getReport();
	
	List<Kae_DriverIdResponse> collectionReport(int kae_id);
	
	public List<KaeKamResponse> reportGet(ReportRequest report); 


	

}
