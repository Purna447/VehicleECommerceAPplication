package com.niit.VehicleServiceApp.repository;



import com.niit.VehicleServiceApp.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleDetailRepository extends MongoRepository<Vehicle,String> {


}
