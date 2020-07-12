package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_driverreg;
import com.example.pharmanic.repositories.Rdhs_driverregRepository;
import com.example.pharmanic.services.Rdhs_driverregService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)

public class Rdhs_driverregController {
    @Autowired
    Rdhs_driverregRepository Rdhs_driverregRepository;

    @Autowired
    Rdhs_driverregService Rdhs_driverregService;

    @GetMapping("/Rdhs_driverreg")
    public List<Rdhs_driverreg> getRdhs_driverregList(){
        return Rdhs_driverregService.getRdhs_driverregList();
    }

    @GetMapping("/Rdhs_driverreg/{nic}")
    public ResponseEntity<Rdhs_driverreg> getRdhs_driverreg(@PathVariable("nic") String nic){
        Rdhs_driverreg Rdhs_driverreg=(Rdhs_driverreg) Rdhs_driverregService.getRdhs_driverregDetails(nic);
        if(Rdhs_driverreg.getNic() !=null){
            return ResponseEntity.ok(Rdhs_driverreg);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/Rdhs_driverreg/add")
    public Integer addRdhs_driverreg(@RequestBody Rdhs_driverreg Rdhs_driverreg){
        return Rdhs_driverregService.addRdhs_driverreg(Rdhs_driverreg);
    }
}
