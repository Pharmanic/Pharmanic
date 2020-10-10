package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Issue_Drugs;
import com.example.pharmanic.repositories.Rdhs_Hospital_Issue_DrugsRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;

@RestController
@RequestMapping("/rdhshospital")
public class Rdhs_Hospital_Issued_DrugsController {

    private Rdhs_Hospital_Issue_DrugsRepository rdhs_hospital_issue_drugsRepository;

    public Rdhs_Hospital_Issued_DrugsController(Rdhs_Hospital_Issue_DrugsRepository rdhs_hospital_issued_drugsRepository) {
        super();
        this.rdhs_hospital_issue_drugsRepository = rdhs_hospital_issued_drugsRepository;
    }

    @GetMapping("/issuedrug")
    Collection<Rdhs_Hospital_Issue_Drugs> issueDrug() {

        return rdhs_hospital_issue_drugsRepository.findAll();
    }
    @PostMapping("/addissue")

    ResponseEntity<Rdhs_Hospital_Issue_Drugs> addIssue(@Validated @RequestBody Rdhs_Hospital_Issue_Drugs rdhs_hospital_issued_drugs) throws URISyntaxException{

        System.out.println("controller"+rdhs_hospital_issued_drugs);
        Rdhs_Hospital_Issue_Drugs result = rdhs_hospital_issue_drugsRepository.save(rdhs_hospital_issued_drugs);
        return ResponseEntity.created(new URI("/rdhshospital/addissue" + result.getIssueId())).body(result);
    }


}
