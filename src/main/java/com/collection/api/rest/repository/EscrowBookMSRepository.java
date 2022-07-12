package com.collection.api.rest.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.collection.api.rest.model.EscrowBookMySql;

@Repository
public interface EscrowBookMSRepository extends JpaRepository<EscrowBookMySql, Integer>
{
	
//	@Query(value = "SELECT b.name AS driver_name "
//			+ "FROM escrow_book AS a INNER JOIN ia_users AS b ON a.driver_id = b.ia_users_id "
//			+ "Where a.driver_id = 742 "
//			+ "group by driver_name;", nativeQuery = true)
//	public String getDriverName(@Param("driver_id")int driver_id); 
	
	@Query(value = "select "
			+ "a.id,"
			+ "a.transaction_id,"
			+ "a.transaction_ref_no,"
			+ "a.amount,"
			+ "a.payment_type,"
			+ "a.payment_mode,"
			+ "a.`status`,"
			+ "Date(a.date_created) as date_created,"
			+ "a.franchise_id,"
			+ "a.driver_id,"
			+ "a.asset_id,"
			+ "a.asset_name,"
			+ "a.balance,"
			+ "a.created_by,"
			+ "a.source_creation,"
			+ "Date(a.system_created_date) as system_created_date,"
			+ "a.is_deleted, "
			+ "a.deleted_by "
			+ "from escrow_book as a "
			+ "where a.is_deleted = 0 and a.driver_id = :driver_id",nativeQuery=true)
	public List<EscrowBookMySql> findByDriverId(@Param("driver_id")int driver_id);
	
	@Query(value="SELECT c.plan_name, "
			+ "d.name AS driver_name, "
			+ "b.plan_start_date, "
			+ "b.plan_id, "
			+ "d.mobile_no "
			+ "FROM escrow_book AS a "
			+ "INNER JOIN ia_assets AS b ON a.driver_id = b.driver_id "
			+ "INNER JOIN ia_plan AS c ON b.plan_id = c.ia_plan_id "
			+ "INNER JOIN ia_users AS d ON a.driver_id = d.ia_users_id "
			+ "WHERE a.driver_id = :driver_id group by plan_id;",nativeQuery = true)
	List<Object[]> getPlanDetails(@Param("driver_id")int driver_id);
	
	@Query(value="SELECT b.plan_id FROM escrow_book AS a INNER JOIN ia_assets AS b ON a.driver_id = b.driver_id WHERE b.deleted = 0 and a.is_deleted = 0 and a.driver_id = :driver_id GROUP BY b.plan_id",nativeQuery = true)
	String findPlanId(@Param("driver_id")int driver_id);
	
	@Query(value="SELECT * FROM escrow_book AS a WHERE a.is_deleted = 0 and a.driver_id = :driver_id AND a.date_created <=:date",nativeQuery = true)
	List<EscrowBookMySql> findDataAtDriverId(@Param("driver_id")int driver_id,@Param("date")Date date);
	
	@Query(value = "SELECT e.name AS KAM, "
			+ "d.name AS KEA, "
			+ "c.name AS Franchise, "
			+ "b.name AS Driver, "
			+ "a.driver_id, "
			+ "a.payment_type, "
			+ "a.amount AS Amount, "
			+ "DATE(a.date_created) as date "
			+ "FROM escrow_book a "
			+ "JOIN ia_users b ON b.ia_users_id = a.driver_id "
			+ "JOIN ia_users c ON c.ia_users_id = b.franchise_id "
			+ "JOIN ia_users d ON d.ia_users_id = c.user_report_to "
			+ "JOIN ia_users e ON e.ia_users_id = c.assigned_kam "
			+ "WHERE b.is_deleted = 0 and YEAR(a.date_created) = Year(now()) and MONTH(a.date_created) = :month "
			+ "GROUP BY DATE(a.date_created), a.driver_id;",nativeQuery=true)
	List<Object[]> findKaeKamReport(@Param("month")String month);
	
	@Query(value ="SELECT "
			+ "e.name AS KAM, "
			+ "d.name AS KEA, "
			+ "c.name AS Franchise, "
			+ "b.name AS Driver, "
			+ "a.driver_id, "
			+ "a.payment_type, "
			+ "a.amount AS Amount, "
			+ "DATE(a.date_created) as date  "
			+ "FROM escrow_book a "
			+ "JOIN ia_users b "
			+ "ON b.ia_users_id = a.driver_id "
			+ "JOIN ia_users c "
			+ "ON c.ia_users_id = b.franchise_id "
			+ "JOIN ia_users d "
			+ "ON d.ia_users_id = c.user_report_to "
			+ "JOIN ia_users e "
			+ "ON e.ia_users_id = c.assigned_kam "
			+ "WHERE b.is_deleted = 0 "
			+ "and YEAR(a.date_created) = year(now()) "
			+ "GROUP BY DATE(a.date_created)",nativeQuery=true)
	List<Object[]> findKaeKamReporting();
	
	
	@Query(value="SELECT d.ia_users_id as driver_id, "
			+ "d.name, "
			+ "d.franchise_id, "
			+ "f.name as franchise_name, "
			+ "d.mobile_no "
			+ "FROM escrow_book "
			+ "INNER JOIN ia_users as d "
			+ "ON d.ia_users_id = escrow_book.driver_id "
			+ "INNER JOIN ia_users as f "
			+ "ON f.ia_users_id = d.franchise_id "
			+ "where escrow_book.is_deleted = '0' "
			+ " and f.user_report_to = :kae_id "
			+ "group by escrow_book.driver_id",nativeQuery=true)
	List<Object[]> findByKae(@Param("kae_id")int kae_id);
}
