package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Driver;
import com.example.pharmanic.model.Rdhs_Vehicle;
import com.example.pharmanic.repositories.Rdhs_DriverRepository;
import com.example.pharmanic.repositories.Rdhs_Vehicle_Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/api")
public class Rdhs_VehicleController {

    private Rdhs_Vehicle_Repository rdhs_vehicle_repository;

    public Rdhs_VehicleController(Rdhs_Vehicle_Repository rdhs_vehicle_repository) {
        super();
        this.rdhs_vehicle_repository = rdhs_vehicle_repository;
    }

    @GetMapping("/allvehicle")
    Collection<Rdhs_Vehicle> allVehicle() {
        return rdhs_vehicle_repository.findAll();
    }
}
