package com.example.pharmanic.web;

import com.example.pharmanic.model.Supply_Order_To_Rdhs;
import com.example.pharmanic.repositories.Supply_Order_To_RdhsRepository;
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
public class Supply_Order_To_RdhsController {
    private final Logger log = LoggerFactory.getLogger(Supply_Order_To_RdhsController.class);
    private Supply_Order_To_RdhsRepository supply_order_to_rdhsRepository;

    public Supply_Order_To_RdhsController(Supply_Order_To_RdhsRepository supply_order_to_rdhsRepository) {
        this.supply_order_to_rdhsRepository = supply_order_to_rdhsRepository;
    }

    @GetMapping("/supplyordertordhss")
    Collection<Supply_Order_To_Rdhs> supplyordertordhss(){
        return supply_order_to_rdhsRepository.findAll();
    }

    @GetMapping("/supplyordertordhs/{id}")
    ResponseEntity<?> getSupplyordertordhs(@PathVariable Long order_id){
        Optional<Supply_Order_To_Rdhs> supply_order_to_rdhs = supply_order_to_rdhsRepository.findById(order_id);
        return supply_order_to_rdhs.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/supplyordertordhs")
    ResponseEntity<Supply_Order_To_Rdhs> createSupplyordertordhs(@Valid @RequestBody Supply_Order_To_Rdhs supply_order_to_rdhs)throws URISyntaxException {
        log.info("Request to create supply order to rdhs: {}", supply_order_to_rdhs);
        Supply_Order_To_Rdhs result = supply_order_to_rdhsRepository.save(supply_order_to_rdhs);
        return ResponseEntity.created(new URI("/api/supplyordertordhs" + result.getOrder_id()))
                .body(result);
    }

    @DeleteMapping("/supplyordertordhs/{id}")
    public ResponseEntity<?> deleteSupplyordertordhs(@PathVariable Long order_id){
        log.info("Request to delete supply order to rdhs: {}",order_id);
        supply_order_to_rdhsRepository.deleteById(order_id);
        return ResponseEntity.ok().build();
    }
}
