package com.example.pharmanic.web;

import com.example.pharmanic.model.Rrdhs_driverreg;
import com.example.pharmanic.repositories.Rrdhs_driverregRepository;
import com.example.pharmanic.services.Rrdhs_driverregService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)

public class Rrdhs_driverregController {
    @Autowired
    Rrdhs_driverregRepository Rrdhs_driverregRepository;

    @Autowired
    Rrdhs_driverregService Rrdhs_driverregService;

    @GetMapping("/Rdhs_driverreg")
    public List<Rrdhs_driverreg> getRdhs_driverregList(){
        return Rrdhs_driverregService.getRdhs_driverregList();
    }

    @GetMapping("/Rdhs_driverreg/{nic}")
    public ResponseEntity<Rrdhs_driverreg> getRdhs_driverreg(@PathVariable("nic") String nic){
        Rrdhs_driverreg Rrdhs_driverreg =(Rrdhs_driverreg) Rrdhs_driverregService.getRdhs_driverregDetails(nic);
        if(Rrdhs_driverreg.getNic() !=null){
            return ResponseEntity.ok(Rrdhs_driverreg);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/rdhs_driverreg/add")
    public Integer addRdhs_driverreg(@RequestBody Rrdhs_driverreg Rrdhs_driverreg){
        return Rrdhs_driverregService.addRdhs_driverreg(Rrdhs_driverreg);
    }
}
