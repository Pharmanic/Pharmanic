package com.example.pharmanic.web;


import com.example.pharmanic.model.Rdhs_Driver;
import com.example.pharmanic.model.Rdhs_Track;
import com.example.pharmanic.repositories.Rdhs_DriverRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/api")
public class Rdhs_DriverController {
    private Rdhs_DriverRepository rdhs_driverRepository;

    public Rdhs_DriverController(Rdhs_DriverRepository rdhs_driverRepository) {
        super();
        this.rdhs_driverRepository = rdhs_driverRepository;
    }
    @GetMapping("/alldriver")
    Collection<Rdhs_Driver> allDriver() {
        return rdhs_driverRepository.findAll();
    }
    @GetMapping("/rdhs_driver/{nic}")
    public ResponseEntity<Rdhs_Driver> getDriver(@PathVariable("nic") String nic){
        Rdhs_Driver rdhs_driver=(Rdhs_Driver) rdhs_driverRepository.findBynic(nic);

        return ResponseEntity.ok(rdhs_driver);

    }

}
