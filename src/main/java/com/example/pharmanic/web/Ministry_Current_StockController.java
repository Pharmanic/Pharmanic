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

    @GetMapping("/yearlyImportMedicieAvg")
    public Integer getyearlyImportMedicieAvg(){
        return ministry_current_stockService.getYearlyImportMedicieAvg();
    }
    @GetMapping("/yearlyImportMedicie5Avg")
    public Integer getyearlyImportMedicie5Avg(){
        return ministry_current_stockService.getYearlyImportMedicieAvg5();
    }
    @GetMapping("/yearlyImportMedicie10Avg")
    public Integer getyearlyImportMedicie10Avg(){
        return ministry_current_stockService.getYearlyImportMedicieAvg10();
    }

    //available charts query
    @GetMapping("/yearlyAvailableMedicieSumYears5")
    public String[] getyearlyAvailableMedicieSumYears5(){
        return ministry_current_stockService.getYearlyAvailableMedicieSumYears5();
    }
    @GetMapping("/yearlyAvailableMedicieSum5")
    public Integer[] getyearlyAvailableMedicieSum5(){
        return ministry_current_stockService.getYearlyAvailableMedicieSum5();
    }

    @GetMapping("/yearlyAvailableMedicieSumYears10")
    public String[] getyearlyAvailableMedicieSumYears10(){
        return ministry_current_stockService.getYearlyAvailableMedicieSumYears10();
    }

    @GetMapping("/yearlyAvailableMedicieSum10")
    public Integer[] getyearlyAvailableMedicieSum10(){
        return ministry_current_stockService.getYearlyAvailableMedicieSum10();
    }

    @GetMapping("/yearlyAvailableMedicieSumYears")
    public String[] getyearlyAvailableMedicieSumYears(){
        return ministry_current_stockService.getYearlyAvailableMedicieSumYears();
    }

    @GetMapping("/yearlyAvailableMedicieSum")
    public Integer[] getyearlyAvailableMedicieSum(){
        return ministry_current_stockService.getYearlyAvailableMedicieSum();
    }

    @GetMapping("/yearlyAvailableMedicieAvg")
    public Integer getyearlyAvailableMedicieAvg(){
        return ministry_current_stockService.getYearlyAvailableMedicieAvg();
    }
    @GetMapping("/yearlyAvailableMedicie5Avg")
    public Integer getyearlyAvailableMedicie5Avg(){
        return ministry_current_stockService.getYearlyAvailableMedicieAvg5();
    }
    @GetMapping("/yearlyAvailableMedicie10Avg")
    public Integer getyearlyAvailableMedicie10Avg(){
        return ministry_current_stockService.getYearlyAvailableMedicieAvg10();
    }
    @GetMapping("/yearlySuppliedMedicieSumYears")
    public String[] getyearlySupplyedMedicieSumYears(){
        return ministry_current_stockService.getYearlySupplyedMedicieSumYears();
    }
    @GetMapping("/yearlySuppliedMedicieSum")
    public Integer[] getyearlySupplyedMedicieSum(){
        return ministry_current_stockService.getYearlySupplyedMedicieSum();
    }
    @GetMapping("/yearlySuppliedMedicieAvg")
    public Integer getyearlySupplyedMedicieAvg(){
        return ministry_current_stockService.getYearlySupplyedMedicieAvg();
    }
    @GetMapping("/yearlySuppliedMedicieSumYears5")
    public String[] getyearlySupplyedMedicieSumYears5(){
        return ministry_current_stockService.getYearlySupplyedMedicieSumYears5();
    }
    @GetMapping("/yearlySuppliedMedicieSum5")
    public Integer[] getyearlySupplyedMedicieSum5(){
        return ministry_current_stockService.getYearlySupplyedMedicieSum5();
    }
    @GetMapping("/yearlySuppliedMedicieAvg5")
    public Integer getyearlySupplyedMedicieAvg5(){
        return ministry_current_stockService.getYearlySupplyedMedicieAvg5();
    }
    @GetMapping("/yearlySuppliedMedicieSumYears10")
    public String[] getyearlySupplyedMedicieSumYears10(){
        return ministry_current_stockService.getYearlySupplyedMedicieSumYears10();
    }
    @GetMapping("/yearlySuppliedMedicieSum10")
    public Integer[] getyearlySupplyedMedicieSum10(){
        return ministry_current_stockService.getYearlySupplyedMedicieSum10();
    }
    @GetMapping("/yearlySuppliedMedicieAvg10")
    public Integer getyearlySupplyedMedicieAvg10(){
        return ministry_current_stockService.getYearlySupplyedMedicieAvg10();
    }

//    @GetMapping("/yearlyDamagedMedicieAvg5")
//    public Integer getyearlyDamagedMedicieAvg5(){
//        return ministry_current_stockService.getYearlyDamagedMedicieAvg5();
//    }
    @GetMapping("/yearlyDamagedMedicieSumYears10")
    public String[] getyearlyDamagedMedicieSumYears10(){
        return ministry_current_stockService.getYearlyDamagedMedicieSumYears10();
    }
    @GetMapping("/yearlyDamagedMedicieSum10")
    public Integer[] getyearlyDamagedMedicieSum10(){
        return ministry_current_stockService.getYearlyDamagedMedicieSum10();
    }
    @GetMapping("/yearlyDamagedMedicieAvg10")
    public Integer getyearlyDamagedMedicieAvg10(){
        return ministry_current_stockService.getYearlyDamagedMedicieAvg10();
    }
    @GetMapping("/yearlyDamagedMedicieSumYears")
    public String[] getyearlyDamagedMedicieSumYears(){
        return ministry_current_stockService.getYearlyDamagedMedicieSumYears();
    }
    @GetMapping("/yearlyDamagedMedicieSum")
    public Integer[] getyearlyDamagedMedicieSum(){
        return ministry_current_stockService.getYearlyDamagedMedicieSum();
    }
    @GetMapping("/yearlyDamagedMedicieAvg")
    public Integer getyearlyDamagedMedicieAvg(){
        return ministry_current_stockService.getYearlyDamagedMedicieAvg();
    }
    @GetMapping("/yearlyDamagedMedicieSumYears5")
    public String[] getyearlyDamagedMedicieSumYears5(){
        return ministry_current_stockService.getYearlyDamagedMedicieSumYears5();
    }
    @GetMapping("/yearlyDamagedMedicieSum5")
    public Integer[] getyearlyDamagedMedicieSum5(){
        return ministry_current_stockService.getYearlyDamagedMedicieSum5();
    }
    @GetMapping("/yearlyDamagedMedicieAvg5")
    public Integer getyearlyDamagedMedicieAvg5() {
        return ministry_current_stockService.getYearlyDamagedMedicieAvg5();
    }

}
