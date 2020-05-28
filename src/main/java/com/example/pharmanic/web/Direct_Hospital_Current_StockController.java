package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Current_Stock;
import com.example.pharmanic.repositories.Direct_Hospital_Current_StockRepository;
import com.example.pharmanic.services.Direct_Hospital_Current_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", maxAge = 3600)
public class Direct_Hospital_Current_StockController {

    @Autowired
    Direct_Hospital_Current_StockRepository direct_hospital_current_stockRepository;

    @Autowired
    Direct_Hospital_Current_StockService direct_hospital_current_stockService;

    @GetMapping("/directhospitalcurrentstocks")
    public List<Direct_Hospital_Current_Stock> getDirectHospitalCurrentStockList(){
        return direct_hospital_current_stockService.getDirectHospitalCurrentStockList();
    }

    @PostMapping("/directhospitalcurrentstock/add")
    public ResponseEntity<Direct_Hospital_Current_Stock> addDirectHospitalCurrentStock(@RequestBody Direct_Hospital_Current_Stock direct_hospital_current_stock) {
        if (direct_hospital_current_stock == null) return ResponseEntity.noContent().build();
        direct_hospital_current_stock = direct_hospital_current_stockService.addDrugsToDirectHospitalCurrentStock(direct_hospital_current_stock);
        return ResponseEntity.ok(direct_hospital_current_stock);
    }

    @PutMapping("/directhospitalcurrentstock/{batch_id}")
    public ResponseEntity<Direct_Hospital_Current_Stock> updateDirectHospitalCurrentStock(@Valid @RequestBody Direct_Hospital_Current_Stock direct_hospital_current_stock){
//        return direct_hospital_current_stockService.updateDirectHospitalCurrentStock(direct_hospital_current_stock);
        Direct_Hospital_Current_Stock result=direct_hospital_current_stockRepository.save(direct_hospital_current_stock);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/directhospitalcurrentstock/{batch_id}")
    Integer deleteDirectHospitalCurrentStockItem(@PathVariable Long batch_id){
        return direct_hospital_current_stockService.deleteDrugsFromDirectHospitalCurrentStock(batch_id);
    }
}
