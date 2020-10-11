package com.example.pharmanic.web;

import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.Ministry_DriverRepository;
import com.example.pharmanic.services.Ministry_DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_DriverController {

    @Autowired
    Ministry_DriverRepository ministry_driverRepository;

    @Autowired
    Ministry_DriverService ministry_driverService;

    @GetMapping("/ministrydrivers")
    public List<Ministry_Driver> getMinistryDriverList(){
        return ministry_driverService.getMinistryDriverList();
    }

    @GetMapping("/ministry_drivers/{nic}")
    public ResponseEntity<Ministry_Driver> getMinistryDriver(@PathVariable("nic") String nic){
        Ministry_Driver ministry_driver=(Ministry_Driver) ministry_driverService.getMinistryDriverDetails(nic);
        if(ministry_driver.getNic() !=null){
            return ResponseEntity.ok(ministry_driver);
        }
        return ResponseEntity.noContent().build();
    }

   // @PostMapping("/ministry_driver/add")
  //  public Integer addMinistryDriver(@RequestBody Ministry_Driver ministry_driver){
       // return ministry_driverService.addDriver(ministry_driver);
   // }

    @PostMapping("/Driver/register")
    public ResponseEntity<Ministry_Driver> addDriver(@RequestBody Ministry_Driver newDriver) {
        if (newDriver == null)
            return ResponseEntity.noContent().build();
        newDriver = ministry_driverService.addDriver(newDriver);
        return ResponseEntity.ok(newDriver);
    }

@DeleteMapping("/deleteministrydriver/{did}")
    public  ResponseEntity<Void> deleteMinistryDriver(@PathVariable("did") String did) {

        String reply=ministry_driverService.deleteministryDriver(did);
        if(reply.equals("success")){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
}

}
