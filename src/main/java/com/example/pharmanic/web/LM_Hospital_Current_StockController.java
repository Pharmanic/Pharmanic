package com.example.pharmanic.web;

import com.example.pharmanic.model.LM_Hospital_Current_Stock;
import com.example.pharmanic.repositories.LM_Hospital_Current_StockRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class LM_Hospital_Current_StockController {
    private LM_Hospital_Current_StockRepository lm_hospital_current_stockRepository;

    public LM_Hospital_Current_StockController(LM_Hospital_Current_StockRepository lm_hospital_current_stockRepository) {
        super();
        this.lm_hospital_current_stockRepository = lm_hospital_current_stockRepository;
    }


    @GetMapping("/dhstock")
    Collection<LM_Hospital_Current_Stock> drugStore() {

        return lm_hospital_current_stockRepository.findAll();
    }

    @GetMapping("/dhstock/{id}")
    ResponseEntity<?> getStock(@PathVariable Long id) {
        Optional<LM_Hospital_Current_Stock> lm_hospital_current_stock = Optional.ofNullable(lm_hospital_current_stockRepository.findByStockId(id));
        return lm_hospital_current_stock.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PostMapping("/dhstock")
    ResponseEntity<LM_Hospital_Current_Stock> createExpense(@Validated @RequestBody LM_Hospital_Current_Stock lm_hospital_current_stock) throws URISyntaxException {
        LM_Hospital_Current_Stock result = lm_hospital_current_stockRepository.save(lm_hospital_current_stock);
        return ResponseEntity.created(new URI("/dhstock" + result.getStockId())).body(result);
    }

    @PutMapping("/dhstock/{id}")
    ResponseEntity<LM_Hospital_Current_Stock> updateExpense(@Validated @RequestBody LM_Hospital_Current_Stock expense) {
        LM_Hospital_Current_Stock result = lm_hospital_current_stockRepository.save(expense);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/dhstock/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        lm_hospital_current_stockRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    //get batch from sr_np
    @RequestMapping(value = "/dhstocksr/{sr_no}", method = RequestMethod.GET)
    List<LM_Hospital_Current_Stock> getBatchByMedicine(@PathVariable("sr_no") String sr_no) {
        return lm_hospital_current_stockRepository.findBySr_no(sr_no);

    }

    @RequestMapping(value = "/dhstockreg/{reg_no}", method = RequestMethod.GET)
    List<LM_Hospital_Current_Stock> getHospitalBatch(@PathVariable("reg_no") String reg_no) {
        return lm_hospital_current_stockRepository.findByreg_no(reg_no);

    }

    @GetMapping("/expired")

    Collection<LM_Hospital_Current_Stock> drugS() {

        return lm_hospital_current_stockRepository.findAll(
                Sort.by(Sort.Direction.ASC,"expiredate"));
    }

    @RequestMapping(value = "/dhexpiration/{reg_no}", method = RequestMethod.GET)
    List<LM_Hospital_Current_Stock> getBatchByAsc(@PathVariable("reg_no") String sr_no) {
        return lm_hospital_current_stockRepository.findByreg_noOrderByexpiredateAsc(sr_no);

    }
    @RequestMapping(value = "/dhlessqty/{reg_no}",method =RequestMethod.GET)
    List<LM_Hospital_Current_Stock> getQtyByasc(@PathVariable("reg_no") String reg_no) {
        return lm_hospital_current_stockRepository.findByreg_noQuantityAsc(reg_no);

    }

}
