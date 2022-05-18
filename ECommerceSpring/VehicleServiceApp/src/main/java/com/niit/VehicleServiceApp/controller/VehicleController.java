package com.niit.VehicleServiceApp.controller;

import com.niit.VehicleServiceApp.exception.VehicleNotFoundException;
import com.niit.VehicleServiceApp.model.Vehicle;
import com.niit.VehicleServiceApp.services.VehicleServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("api/v2")
public class VehicleController {

    private VehicleServicesImpl vehicleServicesImpl;
    @Autowired
    public VehicleController(VehicleServicesImpl vehicleServicesImpl) {
        this.vehicleServicesImpl = vehicleServicesImpl;
    }
    public ResponseEntity responseEntity;

    @PostMapping("vehicle")
    public ResponseEntity<?> saveVehicle(@RequestBody Vehicle vehicle) throws VehicleNotFoundException {
        try{
            return new ResponseEntity<>(vehicleServicesImpl.saveVehicle(vehicle), HttpStatus.CREATED);
        }
        catch (VehicleNotFoundException u){
            throw new VehicleNotFoundException();
        }
        catch(Exception e){
            return  new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping(value="getVehicle")
    public  ResponseEntity<?> getAllVehicle() throws Exception{
        try{
            return  new  ResponseEntity<>(vehicleServicesImpl.getAllVehicle(), HttpStatus.OK);
        }
        catch (Exception u){
            return new ResponseEntity<>("try after some time",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
//    @PutMapping("vehicle/{vehicleId}")
//    public ResponseEntity<?> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable String vehicleId)throws VehicleNotFoundException {
//        try {
//            return new ResponseEntity<>(vehicleServicesImpl.updateVehicle(vehicle, vehicleId), HttpStatus.OK);
//        } catch (VehicleNotFoundException u) {
//            throw new VehicleNotFoundException();
//        } catch (Exception e) {
//            return new ResponseEntity<>("try after time", HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//    }

    @DeleteMapping("/vehicle/{vehicleId}")
    public ResponseEntity<?> deleteVehicle(@PathVariable("vehicleId") String vehicleId) throws VehicleNotFoundException{
        try{
            vehicleServicesImpl.deleteVehicle(vehicleId);
            responseEntity = new ResponseEntity<>("Successfully deleted !!!", HttpStatus.OK);
        }
        catch(VehicleNotFoundException e)
        {
            throw  new VehicleNotFoundException();
        }
        catch(Exception exception)
        {
            String ex = exception.getMessage();
            System.out.println(exception.getMessage());
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }


}
