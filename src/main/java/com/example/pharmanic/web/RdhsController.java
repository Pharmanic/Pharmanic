package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Vehicle;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.RdhsRepository;
import com.example.pharmanic.services.RdhsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class RdhsController {

    @Autowired
    RdhsRepository rdhsRepository;

    @Autowired
    RdhsService rdhsService;

    @GetMapping("/rdhss")
    public List<Rdhs> getRdhsList(){
        return rdhsService.getRdhsList();
    }

    @GetMapping("/rdhss/{reg_no}")
    public ResponseEntity<Rdhs> getRdhs(@PathVariable("reg_no") String reg_no){
        Rdhs rdhs=(Rdhs) rdhsService.getRdhsDetails(reg_no);
        if(rdhs.getReg_no() !=null){
            return ResponseEntity.ok(rdhs);
        }
        return ResponseEntity.noContent().build();
    }
}
