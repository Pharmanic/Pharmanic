package com.example.pharmanic.web;

import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.repositories.MedicineRepository;
import com.example.pharmanic.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class MedicineController {

    @Autowired
    MedicineRepository medicineRepository;

    @Autowired
    MedicineService medicineService;

    @GetMapping("/medicines")
    public List<Medicine> medicines(){
        return medicineService.getMedicineList();
    }

    @GetMapping("/medicines/{sr_no}")
    public ResponseEntity<Medicine> getMdicine(@PathVariable("sr_no") String sr_no){
        Medicine medicine=(Medicine) medicineService.getMedicineDetails(sr_no);
        if(medicine.getSr_no() !=null){
            return ResponseEntity.ok(medicine);
        }
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/Mediciness/register")
    public ResponseEntity<Medicine> addMedicine(@RequestBody Medicine newMedicine) {
        if (newMedicine == null)
            return ResponseEntity.noContent().build();
        newMedicine = medicineService.addMedicine(newMedicine);
        return ResponseEntity.ok(newMedicine);
    }

    @DeleteMapping("/deleteministrymedicene/{mid}")
    public  ResponseEntity<Void> deleteMinistryDriver(@PathVariable("mid") String mid) {

        String reply=medicineService.deleteministrymedicene(mid);
        if(reply.equals("success")){
            return  ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }


}
