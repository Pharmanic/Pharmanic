package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.QtyYear;
import com.example.pharmanic.repositories.Ministry_Current_StockRepository;
import com.example.pharmanic.services.Ministry_Current_StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_Current_StockController {

    @Autowired
    Ministry_Current_StockRepository ministry_current_stockRepository;

    @Autowired
    Ministry_Current_StockService ministry_current_stockService;

    @GetMapping("/ministrycurrentstocks")
    public List<Ministry_Current_Stock> getMinistryCurrentStockList(){
        return ministry_current_stockService.getMinistryCurrentStockList();
    }

    @GetMapping("/ministrynearestexpiringlist")
    public List<Ministry_Current_Stock> getNearestExpiringList(){
        return ministry_current_stockService.getNearestExpiringMedicineList();
    }

    @PostMapping("/ministrycurrentstock/add")
    public Integer addMinistryCurrentStock(@RequestBody Ministry_Current_Stock ministry_current_stock){
        return ministry_current_stockService.addDrugsToMinistryCurrentStock(ministry_current_stock);
    }

    @PutMapping("/ministrycurrentstock/update")
    public ResponseEntity<Ministry_Current_Stock> updateMinistryCurrentStock(@Valid @RequestBody Ministry_Current_Stock object) {
        Ministry_Current_Stock ministry_current_stock = ministry_current_stockService.updateMinistryCurrentStock(object);
        if (ministry_current_stock.getBatch_id() != null) {
            return ResponseEntity.ok(ministry_current_stock);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/ministrycurrentstock/{batch_id}")
    public ResponseEntity<Void> deleteCurrentStock(@PathVariable("batch_id") Long batch_id) {
      //  System.out.println("In vehicleId controller delete method");

        String reply = ministry_current_stockService.deleteministryCurrentStock(batch_id);
        if (reply.equals("success")) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/yearlyImportMedicieSumYears5")
    public String[] getyearlyImportMedicieSumYears5(){
        return ministry_current_stockService.getYearlyImportMedicieSumYears5();
    }

    @GetMapping("/yearlyImportMedicieSum5")
    public Integer[] getyearlyImportMedicieSum5(){
        return ministry_current_stockService.getYearlyImportMedicieSum5();
    }

    @GetMapping("/yearlyImportMedicieSumYears10")
    public String[] getyearlyImportMedicieSumYears10(){
        return ministry_current_stockService.getYearlyImportMedicieSumYears10();
    }

    @GetMapping("/yearlyImportMedicieSum10")
    public Integer[] getyearlyImportMedicieSum10(){
        return ministry_current_stockService.getYearlyImportMedicieSum10();
    }

    @GetMapping("/yearlyImportMedicieSumYears")
    public String[] getyearlyImportMedicieSumYears(){
        return ministry_current_stockService.getYearlyImportMedicieSumYears();
    }

    @GetMapping("/yearlyImportMedicieSum")
    public Integer[] getyearlyImportMedicieSum(){
        return ministry_current_stockService.getYearlyImportMedicieSum();
    }
}
