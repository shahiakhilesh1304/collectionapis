package com.collection.api.rest.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.collection.api.rest.model.IaPlan;

@Repository
public interface IaPlanRepository extends MongoRepository<IaPlan, Integer> 
{
	@Query("{ia_plan_id:?0}")
	public IaPlan findByIa_Plan_Id(int planid);
}
