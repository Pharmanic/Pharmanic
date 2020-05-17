package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.repositories.Ministry_VehicleRepository;
import com.example.pharmanic.services.Ministry_VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_VehicleController {

    @Autowired
    Ministry_VehicleRepository ministry_vehicleRepository;

    @Autowired
    Ministry_VehicleService ministry_vehicleService;

    @GetMapping("/ministryvehicles")
    public List<Ministry_Vehicle> getMinistryVehicleList(){
        return ministry_vehicleService.getMinistryVehicleList();
    }

    @GetMapping("/ministry_vehicles/{vehicle_no}")
    public ResponseEntity<Ministry_Vehicle> getMinistryVehicle(@PathVariable("vehicle_no") String vehicle_no){
        Ministry_Vehicle ministry_vehicle=(Ministry_Vehicle) ministry_vehicleService.getMinistryVehicleDetails(vehicle_no);
        if(ministry_vehicle.getVehicle_no() !=null){
            return ResponseEntity.ok(ministry_vehicle);
        }
        return ResponseEntity.noContent().build();
    }
}
