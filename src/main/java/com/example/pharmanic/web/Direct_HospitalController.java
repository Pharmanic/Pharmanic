package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.repositories.Direct_HospitalRepository;
import com.example.pharmanic.services.Direct_HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Direct_HospitalController {

    @Autowired
    Direct_HospitalRepository direct_hospitalRepository;

    @Autowired
    Direct_HospitalService direct_hospitalService;

    @GetMapping("/direct_hospital/direct_hospital_list")
    public List<Direct_Hospital> directhospitals(){
        return direct_hospitalService.getDirectHospitalList();
    }

    @GetMapping("/directhospitals/{reg_no}")
    public ResponseEntity<Direct_Hospital> getDirectHospital(@PathVariable("reg_no") String reg_no){
        Direct_Hospital direct_hospital =(Direct_Hospital) direct_hospitalService.getDirectHospitalDetails(reg_no);
        if(direct_hospital.getReg_no() != null){
            return ResponseEntity.ok(direct_hospital);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/direct_hospital/register")
    public ResponseEntity<Direct_Hospital> addDirectHospital(@RequestBody Direct_Hospital newDirect_hospital) {
        if (newDirect_hospital == null)
            return ResponseEntity.noContent().build();
        newDirect_hospital = direct_hospitalService.addDirectHospital(newDirect_hospital);
        return ResponseEntity.ok(newDirect_hospital);
    }

    @PutMapping("/directhospital")
    public ResponseEntity<Direct_Hospital> updateDirect_Hospital(@RequestBody Direct_Hospital newDirect_hospital) {

        if(direct_hospitalService.updateDirectHospital(newDirect_hospital)!=null){
            return ResponseEntity.ok(newDirect_hospital);
        }
        return ResponseEntity.noContent().build();

    }

    @DeleteMapping("/directhospital/{reg_no}")
    public ResponseEntity<Integer> deleteRdhs(@PathVariable String reg_no) {
        Integer reply=direct_hospitalService.deleteDirectHospital(reg_no);

        if (reply != null) {
            return ResponseEntity.ok(reply);
        }
        return ResponseEntity.notFound().build();
    }
}
