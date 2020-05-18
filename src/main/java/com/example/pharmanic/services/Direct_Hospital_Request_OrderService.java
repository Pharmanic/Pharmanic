package com.example.pharmanic.services;

import com.example.pharmanic.repositories.Direct_Hospital_Request_OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Direct_Hospital_Request_OrderService {

    @Autowired
    Direct_Hospital_Request_OrderRepository direct_hospital_request_orderRepository;


}
