package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.model.Rdhs;
import com.example.pharmanic.repositories.Ministry_StoreRepository;
import com.example.pharmanic.services.Ministry_StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Ministry_StoreController {

    @Autowired
    Ministry_StoreRepository ministry_storeRepository;

    @Autowired
    Ministry_StoreService ministry_storeService;

    @GetMapping("/ministrystores")
    public List<Ministry_Store> getMinistryStoreList(){
        return ministry_storeService.getMinistryStoreList();
    }

    @GetMapping("/ministry_stores/{m_store_id}")
    public ResponseEntity<Ministry_Store> getMinistryStore(@PathVariable("m_store_id") Long m_store_id){
        Ministry_Store ministry_store=(Ministry_Store) ministry_storeService.getMinistryStoreDetails(m_store_id);
        if(ministry_store.getM_store_id() !=null){
            return ResponseEntity.ok(ministry_store);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/ministry_store")
    Ministry_Store addMinistryStore(@RequestBody Ministry_Store ministry_Store) {
        if(ministry_Store==null)
            return null;
        return ministry_storeService.addMinistryStore(ministry_Store);
    }

    @PutMapping("/ministry_store")
    Ministry_Store updateMinistryStore(@RequestBody Ministry_Store new_Ministry_Store) {

//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
        return  ministry_storeService.updateMinistryStore(new_Ministry_Store);

    }

    @DeleteMapping("/ministry_store/{ministry_id}")
    Integer deleteMinistryStore(@PathVariable Long ministry_id) {
        return ministry_storeService.deleteMinistryStore(ministry_id);
    }
}
