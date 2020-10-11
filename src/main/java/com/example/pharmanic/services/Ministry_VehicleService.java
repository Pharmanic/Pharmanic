package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.repositories.Ministry_VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_VehicleService {

    @Autowired
    Ministry_VehicleRepository ministry_vehicleRepository;

    //getMinistryVehicleList
    public List<Ministry_Vehicle> getMinistryVehicleList(){
        List<Ministry_Vehicle> ministry_vehicleList=ministry_vehicleRepository.findAll();
        return ministry_vehicleList;
    }

    //getMinistryVehicleDetails
    public Ministry_Vehicle getMinistryVehicleDetails(String vehicle_no){
        if (vehicle_no !=null){
            if (ministry_vehicleRepository.existsById(vehicle_no)){
                return ministry_vehicleRepository.findByVehicle_no(vehicle_no);
            }
        }
        return new Ministry_Vehicle();
    }

    //addMedicine

        //addDrugsToMinistryCurrentStore
    public Ministry_Vehicle addVehicle(Ministry_Vehicle ministry_vehicle){
       return ministry_vehicleRepository.save(ministry_vehicle);
    }

    public  String deleteministryVehicle(String vid){
        if(vid != null){
            if(ministry_vehicleRepository.existsById(vid)){

                ministry_vehicleRepository.deleteById(vid);
                return  "success";
            }

        }

        return  " error";
    }

}
