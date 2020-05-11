package com.example.pharmanic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ministry_DriverController {
    private final Ministry_DriverRepository repository;

    public Ministry_DriverController(Ministry_DriverRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/drivers")
    List<Ministry_Driver> all(){
        return repository.findAll();
    }

    @PostMapping("driver")
    Ministry_Driver newDriver(@RequestBody Ministry_Driver newMinistryDriver){
        return repository.save(newMinistryDriver);
    }
}
