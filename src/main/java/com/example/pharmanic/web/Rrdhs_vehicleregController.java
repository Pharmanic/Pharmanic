package com.example.pharmanic.web;

import com.example.pharmanic.model.Rrdhs_vehiclereg;
import com.example.pharmanic.repositories.Rrdhs_vehicleregRepository;
import com.example.pharmanic.services.Rrdhs_vehicleregService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Rrdhs_vehicleregController {
    @Autowired
    Rrdhs_vehicleregRepository Rrdhs_vehicleregRepository;

    @Autowired
    Rrdhs_vehicleregService Rrdhs_vehicleregService;

    @GetMapping("/Rdhs_vehiclereg")
    public List<Rrdhs_vehiclereg> getRdhs_vehicleregList(){
        return Rrdhs_vehicleregService.getRdhs_vehicleregList();
    }

    @GetMapping("/Rdhs_vehiclereg/{vehicle_no}")
    public ResponseEntity<Rrdhs_vehiclereg> getRdhs_vehiclereg(@PathVariable("vehicle_no") String vehicle_no){
        Rrdhs_vehiclereg Rrdhs_vehiclereg =(Rrdhs_vehiclereg) Rrdhs_vehicleregService.getRdhs_vehicleregDetails(vehicle_no);
        if(Rrdhs_vehiclereg.getVehicle_no() !=null){
            return ResponseEntity.ok(Rrdhs_vehiclereg);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/rdhs_vehiclereg/add")
    public Integer addRdhs_vehiclereg(@RequestBody Rrdhs_vehiclereg Rrdhs_vehiclereg){
        return Rrdhs_vehicleregService.addRdhs_vehiclereg(Rrdhs_vehiclereg);
    }
}
