package com.example.pharmanic.web;

import com.example.pharmanic.model.Supply_Order_Detail_To_Rdhs;
import com.example.pharmanic.repositories.Supply_Order_Detail_To_RdhsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Supply_Order_Detail_To_RdhsController {
    private final Logger log = LoggerFactory.getLogger(Supply_Order_Detail_To_RdhsController.class);
    private Supply_Order_Detail_To_RdhsRepository supply_order_detail_to_rdhsRepository;

    public Supply_Order_Detail_To_RdhsController(Supply_Order_Detail_To_RdhsRepository supply_order_detail_to_rdhsRepository) {
        this.supply_order_detail_to_rdhsRepository = supply_order_detail_to_rdhsRepository;
    }

    @GetMapping("/supplyorderdetailtordhss")
    Collection<Supply_Order_Detail_To_Rdhs> supplyorderdetailtordhss(){
        return supply_order_detail_to_rdhsRepository.findAll();
    }

    @GetMapping("/supplyorderdetailtordhs/{id}")
    ResponseEntity<?> getSupplyorderdetailtordhs(@PathVariable Long id){
        Optional<Supply_Order_Detail_To_Rdhs> supply_order_detail_to_rdhs=supply_order_detail_to_rdhsRepository.findById(id);
        return supply_order_detail_to_rdhs.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping("/supplyorderdetailtordhs")
    ResponseEntity<Supply_Order_Detail_To_Rdhs> createSupplyorderdetailtordhs(@Valid @RequestBody Supply_Order_Detail_To_Rdhs supply_order_detail_to_rdhs) throws URISyntaxException{
        log.info("Request to create supply order detail to rdhs: {}",supply_order_detail_to_rdhs);
        Supply_Order_Detail_To_Rdhs result = supply_order_detail_to_rdhsRepository.save(supply_order_detail_to_rdhs);
        return ResponseEntity.created(new URI("/api/supplyorderdetailtordhs/"+result.getId()))
                .body(result);
    }

    @DeleteMapping("/supplyorderdetailtordhs/{id}")
    public ResponseEntity<?> deleteSupplyorderdetailtordhs(@PathVariable Long id){
        log.info("Request to delete supply order detail to rdhs: {}",id);
        supply_order_detail_to_rdhsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
