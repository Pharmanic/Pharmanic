package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.repositories.Rdhs_Hospital_Current_StockRepository;
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
@RequestMapping("/api")
public class Rdhs_Hospital_Current_StockController {
    private Rdhs_Hospital_Current_StockRepository rdhs_hospital_current_stockRepository;

    public Rdhs_Hospital_Current_StockController(Rdhs_Hospital_Current_StockRepository rdhs_hospital_current_stockRepository) {
        super();
        this.rdhs_hospital_current_stockRepository = rdhs_hospital_current_stockRepository;
    }


    @GetMapping("/rhstock")
    Collection<Rdhs_Hospital_Current_Stock> drugStore() {

        return rdhs_hospital_current_stockRepository.findAll();
    }

    @GetMapping("/rhstock/{id}")
    ResponseEntity<?> getStock(@PathVariable Long id) {
        Optional<Rdhs_Hospital_Current_Stock> rdhs_hospital_current_stock = Optional.ofNullable(rdhs_hospital_current_stockRepository.findByStockId(id));
        return rdhs_hospital_current_stock.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }



    @PostMapping("/rhstock")
    ResponseEntity<Rdhs_Hospital_Current_Stock> createExpense(@Validated @RequestBody Rdhs_Hospital_Current_Stock rdhs_hospital_current_stock) throws URISyntaxException {
        Rdhs_Hospital_Current_Stock result = rdhs_hospital_current_stockRepository.save(rdhs_hospital_current_stock);
        return ResponseEntity.created(new URI("/api/rhstock" + result.getStockId())).body(result);
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

    //get batch from sr_np
    @RequestMapping(value = "/rhstocksr/{sr_no}", method = RequestMethod.GET)
    List<Rdhs_Hospital_Current_Stock> getBatchByMedicine(@PathVariable("sr_no") String sr_no) {
        return rdhs_hospital_current_stockRepository.findBySr_no(sr_no);

    }

    @RequestMapping(value = "/rhstockreg/{reg_no}", method = RequestMethod.GET)
    List<Rdhs_Hospital_Current_Stock> getHospitalBatch(@PathVariable("reg_no") String reg_no) {
        return rdhs_hospital_current_stockRepository.findByreg_no(reg_no);

    }

    @GetMapping("/expired")

    Collection<Rdhs_Hospital_Current_Stock> drugS() {

        return rdhs_hospital_current_stockRepository.findAll(
                Sort.by(Sort.Direction.ASC,"expiredate"));
    }
  /*  @RequestMapping(value = "/rhstockreg/{reg_no}", method = RequestMethod.GET)
    List<Rdhs_Hospital_Current_Stock> sortbatch(@PathVariable("reg_no") String reg_no) {
        return rdhs_hospital_current_stockRepository.findAll(
                Sort.by(Sort.Direction.ASC,"expiredate"));


    }*/
  @RequestMapping(value = "/expiration/{reg_no}", method = RequestMethod.GET)
  List<Rdhs_Hospital_Current_Stock> getBatchByAsc(@PathVariable("reg_no") String sr_no) {
      return rdhs_hospital_current_stockRepository.findByreg_noOrderByexpiredateAsc(sr_no);

  }
  @RequestMapping(value = "/lessqty/{reg_no}",method =RequestMethod.GET)
  List<Rdhs_Hospital_Current_Stock> getQtyByasc(@PathVariable("reg_no") String reg_no) {
      return rdhs_hospital_current_stockRepository.findByreg_noQuantityAsc(reg_no);

  }

}
