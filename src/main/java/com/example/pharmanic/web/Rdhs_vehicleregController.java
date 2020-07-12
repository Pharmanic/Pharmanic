package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.model.Rdhs_vehiclereg;
import com.example.pharmanic.repositories.Ministry_VehicleRepository;
import com.example.pharmanic.repositories.Rdhs_vehicleregRepository;
import com.example.pharmanic.services.Ministry_VehicleService;
import com.example.pharmanic.services.Rdhs_vehicleregService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Rdhs_vehicleregController {
    @Autowired
    Rdhs_vehicleregRepository Rdhs_vehicleregRepository;

    @Autowired
    Rdhs_vehicleregService Rdhs_vehicleregService;

    @GetMapping("/Rdhs_vehiclereg")
    public List<Rdhs_vehiclereg> getRdhs_vehicleregList(){
        return Rdhs_vehicleregService.getRdhs_vehicleregList();
    }

    @GetMapping("/Rdhs_vehiclereg/{vehicle_no}")
    public ResponseEntity<Rdhs_vehiclereg> getRdhs_vehiclereg(@PathVariable("vehicle_no") String vehicle_no){
        Rdhs_vehiclereg Rdhs_vehiclereg=(Rdhs_vehiclereg) Rdhs_vehicleregService.getRdhs_vehicleregDetails(vehicle_no);
        if(Rdhs_vehiclereg.getVehicle_no() !=null){
            return ResponseEntity.ok(Rdhs_vehiclereg);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/Rdhs_vehiclereg/add")
    public Integer addRdhs_vehiclereg(@RequestBody Rdhs_vehiclereg Rdhs_vehiclereg){
        return Rdhs_vehicleregService.addRdhs_vehiclereg(Rdhs_vehiclereg);
    }
}
