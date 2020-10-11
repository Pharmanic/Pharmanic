package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Request_Order;
import com.example.pharmanic.model.Rdhs_Hospital_Request_Order_Cart;
import com.example.pharmanic.repositories.Rdhs_Hospital_Request_OrderRepository;
//import com.example.pharmanic.services.Rdhs_Hospital_Request_OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/rhRequestOrder")
public class Rdhs_Hospital_Request_OrderController {
    @Autowired
    private Rdhs_Hospital_Request_OrderRepository rdhs_hospital_request_orderRepository;

//    @Autowired
//    private Rdhs_Hospital_Request_OrderService rdhs_hospital_request_orderService;

    public Rdhs_Hospital_Request_OrderController(Rdhs_Hospital_Request_OrderRepository rdhs_hospital_request_orderRepository) {
        super();
        this.rdhs_hospital_request_orderRepository = rdhs_hospital_request_orderRepository;
    }
//    @PostMapping("/addOrder")
//    ResponseEntity<Rdhs_Hospital_Request_Order> addItem(@Validated @RequestBody Rdhs_Hospital_Request_Order rdhs_hospital_request_order_cart) throws URISyntaxException {
//        Rdhs_Hospital_Request_Order result = rdhs_hospital_request_orderRepository.save(rdhs_hospital_request_order_cart);
//        return ResponseEntity.created(new URI("/rhRequestOrder/addOrder" + result.getOrderId())).body(result);
//    }
}
