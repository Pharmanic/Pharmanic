package com.example.pharmanic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Ministry_StoreController {
    private final Ministry_StoreRepository repository;

    public Ministry_StoreController(Ministry_StoreRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/stores")
    List<Ministry_Store> all(){
        return repository.findAll();
    }

    @PostMapping("store")
    Ministry_Store newStore(@RequestBody Ministry_Store newMinistryStore){
        return repository.save(newMinistryStore);
    }
}
