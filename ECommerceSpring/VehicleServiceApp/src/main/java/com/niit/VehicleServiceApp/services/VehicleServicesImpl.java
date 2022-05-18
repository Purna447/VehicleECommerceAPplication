package com.niit.VehicleServiceApp.services;


import com.niit.VehicleServiceApp.exception.VehicleNotFoundException;
import com.niit.VehicleServiceApp.model.Vehicle;
import com.niit.VehicleServiceApp.repository.VehicleDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class VehicleServicesImpl implements VehicleService {
    private VehicleDetailRepository vehicleDetailRepository;

    @Autowired
    public VehicleServicesImpl(VehicleDetailRepository vehicleDetailRepository){

        this.vehicleDetailRepository=vehicleDetailRepository;
    }


    @Override
    public Vehicle saveVehicle( Vehicle vehicle) throws VehicleNotFoundException {
//        if(vehicleDetailRepository.findById(vehicle.getVehicleId()).isPresent()){
//            throw new VehicleNotFoundException();
//        }
        return vehicleDetailRepository.save(vehicle);
    }


    @Override
    public List<Vehicle> getAllVehicle() throws VehicleNotFoundException {
        return vehicleDetailRepository.findAll();
    }

    @Override
    public Vehicle updateVehicle( Vehicle vehicle,String vehicleId) throws VehicleNotFoundException {
        if(vehicleDetailRepository.findById(vehicle.getVehicleId()).isEmpty()){
            throw new VehicleNotFoundException();
        }

        return vehicleDetailRepository.save(vehicle);
    }

    @Override
    public boolean deleteVehicle(String vehicleId) throws VehicleNotFoundException {

        boolean flag = false;
        if(vehicleDetailRepository.findById(vehicleId).isEmpty())
        {
            throw new VehicleNotFoundException();
        }
        else
        {
            vehicleDetailRepository.deleteById(vehicleId);
            flag=true;
        }
        return flag;
    }
}