package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Current_Stock;
import com.example.pharmanic.model.Ministry_Current_StockRepository;
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
public class Ministry_Current_StockController {
    private final Logger log = LoggerFactory.getLogger(Ministry_Current_StockController.class);
    private Ministry_Current_StockRepository ministry_current_stockRepository;

    public Ministry_Current_StockController(Ministry_Current_StockRepository ministry_current_stockRepository) {
        this.ministry_current_stockRepository = ministry_current_stockRepository;
    }

    @GetMapping("/ministrycurrentstocks")
    Collection<Ministry_Current_Stock> ministrycurrentstocks(){
        return ministry_current_stockRepository.findAll();
    }

    @GetMapping("/ministrycurrentstock/{id}")
    ResponseEntity<?> getMinistrycurrentstock(@PathVariable Long batch_id){
        Optional<Ministry_Current_Stock> ministry_current_stock=ministry_current_stockRepository.findById(batch_id);
        return ministry_current_stock.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/ministrycurrentstock")
    ResponseEntity<Ministry_Current_Stock> createMinistrycurrentstock(@Valid @RequestBody Ministry_Current_Stock ministry_current_stock) throws URISyntaxException {
        log.info("Request to create ministry current stock: {} ",ministry_current_stock);
        Ministry_Current_Stock result = ministry_current_stockRepository.save(ministry_current_stock);
        return ResponseEntity.created(new URI("/api/ministrycurrentstock" + result.getBatch_id()))
                .body(result);
    }

    @DeleteMapping("/ministrycurrentstock/{id}")
    public ResponseEntity<?> deleteMinistrycurrentstock(@PathVariable Long batch_id){
        log.info("Request to delete ministry current store:{}",batch_id);
        ministry_current_stockRepository.deleteById(batch_id);
        return ResponseEntity.ok().build();
    }



}
