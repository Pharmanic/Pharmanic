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

}
