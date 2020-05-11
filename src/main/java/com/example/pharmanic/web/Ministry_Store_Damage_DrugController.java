package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Store_Damage_Drug;
import com.example.pharmanic.model.Ministry_Store_Damage_DrugRepository;
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
public class Ministry_Store_Damage_DrugController {
    private final Logger log = LoggerFactory.getLogger(Ministry_Store_Damage_DrugController.class);
    private Ministry_Store_Damage_DrugRepository ministry_store_damage_drugRepository;

    public Ministry_Store_Damage_DrugController(Ministry_Store_Damage_DrugRepository ministry_store_damage_drugRepository) {
        this.ministry_store_damage_drugRepository = ministry_store_damage_drugRepository;
    }

    @GetMapping("/ministrystoredamagedrugs")
    Collection<Ministry_Store_Damage_Drug> ministryStoreDamageDrugs(){
        return ministry_store_damage_drugRepository.findAll();
    }

    @GetMapping("/ministrystoredamagedrug/{id}")
    ResponseEntity<?> getministryStoreDamageDrug(@PathVariable Long did){
        Optional<Ministry_Store_Damage_Drug> ministry_store_damage_drug = ministry_store_damage_drugRepository.findById(did);
        return ministry_store_damage_drug.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/ministrystoredamagedrug")
    ResponseEntity<Ministry_Store_Damage_Drug> createministryStoreDamageDrug(@Valid @RequestBody Ministry_Store_Damage_Drug ministry_store_damage_drug)throws URISyntaxException{
        log.info("Request to create ministry store dmage drug:{}",ministry_store_damage_drug);
        Ministry_Store_Damage_Drug result=ministry_store_damage_drugRepository.save(ministry_store_damage_drug);
        return ResponseEntity.created(new URI("/api/ministrystoredamagedrug/" + result.getDid()))
                .body(result);

    }

    @DeleteMapping("/ministrystoredamagedrug/{id}")
    public ResponseEntity<?> deleteministrystoredamagedrug(@PathVariable Long did){
        log.info("Request to delete group: {}",did);
        ministry_store_damage_drugRepository.deleteById(did);
        return ResponseEntity.ok().build();
    }
}
