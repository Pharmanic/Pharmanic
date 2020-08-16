package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.model.Rdhs_Request_Order;
import com.example.pharmanic.repositories.Rdhs_Request_OrderRepository;
import com.example.pharmanic.services.Rdhs_Request_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*",maxAge = 3600)
public class Rdhs_Request_OrderController {

    @Autowired
    Rdhs_Request_OrderRepository rdhs_request_orderRepository;

    @Autowired
    Rdhs_Request_OrderService rdhs_request_orderService;

    @GetMapping("/rdhsrequestorders")
    public List<Rdhs_Request_Order> rdhsrequestorders(){
        return rdhs_request_orderService.getRDHSRequestOrderList();
    }


    @GetMapping("/rdhsrequestordersnotcomplete")
    public List<Rdhs_Request_Order> rdhsrequestordersnotcomplete(){
        return rdhs_request_orderService.getnotcompleteRdhsRequestOrderList();
    }

    @PostMapping("/rdhsrequestorder/add")
    public Integer addRdhsRequestOrder(@RequestBody Rdhs_Request_Order rdhs_request_order){
        return rdhs_request_orderService.addRdhsRequestOrder(rdhs_request_order);
    }
}
