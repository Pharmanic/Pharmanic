package com.example.pharmanic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ministry_VehicleController {
    private final Ministry_VehicleRepository repository;

    public Ministry_VehicleController(Ministry_VehicleRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/vehicles")
    List<Ministry_Vehicle> all(){
        return repository.findAll();
    }

    @PostMapping("/vehicle")
    Ministry_Vehicle newVeicle(@RequestBody Ministry_Vehicle newMinistryVehicle){
        return repository.save(newMinistryVehicle);
    }
}
