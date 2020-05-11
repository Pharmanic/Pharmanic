package com.example.pharmanic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RdhsController {
    private final RdhsRepository repository;

    public RdhsController(RdhsRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/rdhss")
    List<Rdhs> all(){
        return repository.findAll();
    }

    @PostMapping("/rdhs")
    Rdhs newRdhs(@RequestBody Rdhs newRdhss){
        return repository.save(newRdhss);
    }
}
