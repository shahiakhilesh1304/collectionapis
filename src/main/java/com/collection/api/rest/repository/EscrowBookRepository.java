package com.collection.api.rest.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.collection.api.rest.model.EscrowBook;

@Repository
public interface EscrowBookRepository extends MongoRepository<EscrowBook, Integer>
{
	@Query("{franchise_id :?0}")  
	public List<EscrowBook> findByFerchise_Id(int franchise_id);
	@Query("{driver_id : ?0}")  
	public List<EscrowBook> findByDriver_Id(int driver_id);
	@Query("{'date_created' : {'$gt': ?0}}")
	public List<EscrowBook> findByDate_Created(Date date_created);
	@Query("{driver_id : ?0}")
	public Optional<EscrowBook> findByDriver_IdData(int col_id);
	@Query("{'date_created' : {'$lte': ?1},driver_id :?0}")
	public List<EscrowBook> findByDriverIdAndDate_Created(int driver_id,Date date_created);
	@Query("{driver_id :?0,}")  
	public List<EscrowBook> findByDriver_IdAndMonth(int driver_id,int month);
}
