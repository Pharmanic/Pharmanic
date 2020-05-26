package com.example.pharmanic.services;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.repositories.Rdhs_Hospital_Current_StockRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Rdhs_Hospital_Current_StockService {
    private Rdhs_Hospital_Current_StockRepository rdhs_hospital_current_stockRepository;

    public Rdhs_Hospital_Current_StockService(Rdhs_Hospital_Current_StockRepository rdhs_hospital_current_stockRepository) {
        super();
        this.rdhs_hospital_current_stockRepository = rdhs_hospital_current_stockRepository;
    }

    @GetMapping("/rhstock")
    Collection<Rdhs_Hospital_Current_Stock> drugStore() {
        return rdhs_hospital_current_stockRepository.findAll();
    }

    @GetMapping("/rhstock/{id}")
    ResponseEntity<?> getMedicine(@PathVariable Long id) {
        Optional<Rdhs_Hospital_Current_Stock> rdhs_hospital_current_stock = Optional.ofNullable(rdhs_hospital_current_stockRepository.findBybatchId(id));
        return rdhs_hospital_current_stock.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/rhstock")
    ResponseEntity<Rdhs_Hospital_Current_Stock> createExpense(@Validated @RequestBody Rdhs_Hospital_Current_Stock rdhs_hospital_current_stock) throws URISyntaxException {
        Rdhs_Hospital_Current_Stock result = rdhs_hospital_current_stockRepository.save(rdhs_hospital_current_stock);
        return ResponseEntity.created(new URI("/api/rhstock" + result.getBatchId())).body(result);
    }

    @PutMapping("/rhstock/{id}")
    ResponseEntity<Rdhs_Hospital_Current_Stock> updateExpense(@Validated @RequestBody Rdhs_Hospital_Current_Stock expense) {
        Rdhs_Hospital_Current_Stock result = rdhs_hospital_current_stockRepository.save(expense);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/rhstock/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        rdhs_hospital_current_stockRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/rhstock/{sr}")
    ResponseEntity<?> getBatchByMedicine(@PathVariable String sr_no) {
        Optional<Rdhs_Hospital_Current_Stock> rdhs_hospital_current_stock = Optional.ofNullable(rdhs_hospital_current_stockRepository.findBySr_no(sr_no));
        return rdhs_hospital_current_stock.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }




}