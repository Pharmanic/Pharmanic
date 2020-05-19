package com.example.pharmanic.web;

import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.repositories.Hospital_By_RdhsRepository;
import com.example.pharmanic.services.Hospital_By_RdhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Hospital_By_RdhsController {

    @Autowired
    Hospital_By_RdhsRepository hospital_by_rdhsRepository;

    @Autowired
    Hospital_By_RdhsService hospital_by_rdhsService;

    @GetMapping("/hospitalsByRdhs")
    public List<Hospital_By_Rdhs> hospitalsByRdhs(){
        return hospital_by_rdhsService.getHospitalsByRdhsList();
    }

    @GetMapping("/hospitalByRdhs/{reg_no}")
    public ResponseEntity<Hospital_By_Rdhs> getHospital_By_Rdhs(@PathVariable("reg_no") String reg_no){
        Hospital_By_Rdhs hospital_by_rdhs =(Hospital_By_Rdhs) hospital_by_rdhsService.getHospitalByRdhsDetails(reg_no);
        if(hospital_by_rdhs.getReg_no() != null){
            return ResponseEntity.ok(hospital_by_rdhs);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/hospitalByRdhs/add")
    public Integer addHospitalByRDHA(@RequestBody Hospital_By_Rdhs hospital_by_rdhs){
        return hospital_by_rdhsService.addHospitalByRdhs(hospital_by_rdhs);
    }

    @PutMapping("hospitalByRdhs/delete/{reg_no}")
    public ResponseEntity<Integer> deleteHospitalByRdhs(@PathVariable("reg_no") String reg_no) {
        Integer reply = hospital_by_rdhsService.deleteHospitalByRdhs(reg_no);
        if (reply != null) {
            return ResponseEntity.ok(reply);
        }
        return ResponseEntity.notFound().build();
    }
}
