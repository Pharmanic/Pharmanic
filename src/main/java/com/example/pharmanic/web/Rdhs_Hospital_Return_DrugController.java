package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.model.Rdhs_Hospital_Return_Drug;

import com.example.pharmanic.repositories.Rdhs_Hospital_Return_DrugRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
@RestController
@RequestMapping("/api")
public class Rdhs_Hospital_Return_DrugController {
    private Rdhs_Hospital_Return_DrugRepository rdhs_hospital_return_drugRepository;

    public Rdhs_Hospital_Return_DrugController(Rdhs_Hospital_Return_DrugRepository rdhs_hospital_return_drugRepository) {
       super();
        this.rdhs_hospital_return_drugRepository = rdhs_hospital_return_drugRepository;
    }

    @GetMapping("/rhreturndrug")
    Collection<Rdhs_Hospital_Return_Drug> drugStore() {

        return rdhs_hospital_return_drugRepository.findAll();
    }

    @PostMapping("/rhreturndrugs")
    ResponseEntity<Rdhs_Hospital_Return_Drug> newReturnRecord(@Validated @RequestBody Rdhs_Hospital_Return_Drug rdhs_hospital_return_drug) throws URISyntaxException {
        Rdhs_Hospital_Return_Drug result = rdhs_hospital_return_drugRepository.save(rdhs_hospital_return_drug);
        return ResponseEntity.created(new URI("/api/rhreturndrugs" + result.getReturned_id())).body(result);
    }

    @PutMapping("/updatereturn{id}")
    ResponseEntity<Rdhs_Hospital_Return_Drug> updateExpense(@Validated @RequestBody Rdhs_Hospital_Return_Drug rdhs_hospital_return_drug) {
        Rdhs_Hospital_Return_Drug result = rdhs_hospital_return_drugRepository.save(rdhs_hospital_return_drug);
        return ResponseEntity.ok().body(result);
    }
    @DeleteMapping("returnitem/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        rdhs_hospital_return_drugRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
