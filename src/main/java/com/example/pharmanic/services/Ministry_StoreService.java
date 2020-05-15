package com.example.pharmanic.services;

import com.example.pharmanic.model.Ministry_Driver;
import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.repositories.Ministry_DriverRepository;
import com.example.pharmanic.repositories.Ministry_StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Ministry_StoreService {

    @Autowired
    Ministry_StoreRepository ministry_storeRepository;

    //getMinistryStoreList
    public List<Ministry_Store> getMinistryStoreList(){
        List<Ministry_Store> ministry_storeList=ministry_storeRepository.findAll();
        return ministry_storeList;
    }

    //getMinistryStoreDetails
    public Ministry_Store getMinistryStoreDetails(Long m_store_id){
        if (m_store_id !=null){
            if (ministry_storeRepository.existsById(m_store_id)){
                return ministry_storeRepository.findByM_store_id(m_store_id);
            }
        }
        return new Ministry_Store();
    }
}
