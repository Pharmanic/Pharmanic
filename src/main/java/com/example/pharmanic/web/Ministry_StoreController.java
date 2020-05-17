package com.example.pharmanic.web;

import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.repositories.Ministry_StoreRepository;
import com.example.pharmanic.services.Ministry_StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
