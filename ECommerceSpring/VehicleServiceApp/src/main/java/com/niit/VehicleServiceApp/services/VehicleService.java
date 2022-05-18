package com.niit.VehicleServiceApp.services;




import com.niit.VehicleServiceApp.exception.VehicleNotFoundException;
import com.niit.VehicleServiceApp.model.Vehicle;

import java.util.List;


public interface VehicleService {

    Vehicle saveVehicle(Vehicle vehicle) throws VehicleNotFoundException;
    List<Vehicle> getAllVehicle() throws Exception;
    Vehicle updateVehicle(Vehicle vehicle,String vehicleId) throws  VehicleNotFoundException;
    boolean deleteVehicle(String vehicleId) throws VehicleNotFoundException;
}
