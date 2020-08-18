package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital;
import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.repositories.Direct_Hospital_Request_OrderRepository;
import com.example.pharmanic.services.Direct_Hospital_Request_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Direct_Hospital_Request_OrderController {

    @Autowired
    Direct_Hospital_Request_OrderRepository direct_hospital_request_orderRepository;

    @Autowired
    Direct_Hospital_Request_OrderService direct_hospital_request_orderService;

    @GetMapping("/directhospitalrequestorders")
    public List<Direct_Hospital_Request_Order> directhospitalrequestorders(){
        return direct_hospital_request_orderService.getDirectHospitalRequestOrderList();
    }

    @GetMapping("/dhrequestordersnotcoplete")
    public List<Direct_Hospital_Request_Order> dhrequestordersnotcomplete(){
        return direct_hospital_request_orderService.getnotcompleteDirectHospitalRequestOrderList();
    }

    @PostMapping("/directhospitalrequestorder/add")
    public Integer addDirectHospitalRequestOrder(@RequestBody Direct_Hospital_Request_Order direct_hospital_request_order){
        return direct_hospital_request_orderService.addDirectHospitalRequestOrder(direct_hospital_request_order);
    }
}
