//package com.example.pharmanic.web;
//
////<<<<<<< HEAD
//import com.example.pharmanic.model.Rdhs_Hospital_Issued_Drugs;
//import com.example.pharmanic.repositories.Rdhs_Hospital_Issued_DrugsRepository;
//import org.springframework.http.ResponseEntity;
////=======
//import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
//import com.example.pharmanic.model.Rdhs_Hospital_Issued_Drugs;
//import com.example.pharmanic.repositories.Rdhs_Hospital_Current_StockRepository;
//import com.example.pharmanic.repositories.Rdhs_Hospital_Issued_DrugsRepository;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageNotReadableException;
////>>>>>>> 08dd94b8ff5aed09b7bf5987f070620df269d71b
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.util.Collection;
//
//@RestController
//@RequestMapping("/rdhshospital")
//public class Rdhs_Hospital_Issued_DrugsController {
////<<<<<<< HEAD
//
//    private Rdhs_Hospital_Issued_DrugsRepository rdhs_hospital_issue_drugsRepository;
//
//    public Rdhs_Hospital_Issued_DrugsController(Rdhs_Hospital_Issued_DrugsRepository rdhs_hospital_issued_drugsRepository) {
//        super();
//        this.rdhs_hospital_issue_drugsRepository = rdhs_hospital_issued_drugsRepository;
//    }
//
//    @GetMapping("/issuedrug")
//    Collection<Rdhs_Hospital_Issued_Drugs> issueDrug() {
//
//        return rdhs_hospital_issue_drugsRepository.findAll();
//    }
//    @PostMapping("/addissue")
//
//    ResponseEntity<Rdhs_Hospital_Issued_Drugs> addIssue(@Validated @RequestBody Rdhs_Hospital_Issued_Drugs rdhs_hospital_issued_drugs) throws URISyntaxException{
//
//        System.out.println("controller"+rdhs_hospital_issued_drugs);
//        Rdhs_Hospital_Issued_Drugs result = rdhs_hospital_issue_drugsRepository.save(rdhs_hospital_issued_drugs);
//
//    private Rdhs_Hospital_Issued_DrugsRepository rdhs_hospital_issued_drugsRepository;
//
//    public Rdhs_Hospital_Issued_DrugsController(Rdhs_Hospital_Issued_DrugsRepository rdhs_hospital_issued_drugsRepository) {
//        super();
//        this.rdhs_hospital_issue_drugsRepository = rdhs_hospital_issued_drugsRepository;
//    }
//
//    @GetMapping("/issuedrug")
//    Collection<Rdhs_Hospital_Issued_Drugs> issueDrug() {
//
//        return rdhs_hospital_issued_drugsRepository.findAll();
//    }
//    @PostMapping("/addissue")
//
//    ResponseEntity<Rdhs_Hospital_Issued_Drugs> addIssue(@Validated @RequestBody Rdhs_Hospital_Issued_Drugs rdhs_hospital_issued_drugs) throws URISyntaxException{
//
//        System.out.println("controller"+rdhs_hospital_issued_drugs);
//        Rdhs_Hospital_Issued_Drugs result = rdhs_hospital_issued_drugsRepository.save(rdhs_hospital_issued_drugs);
////>>>>>>> 08dd94b8ff5aed09b7bf5987f070620df269d71b
//        return ResponseEntity.created(new URI("/rdhshospital/addissue" + result.getIssueId())).body(result);
//    }
//
//
//}
