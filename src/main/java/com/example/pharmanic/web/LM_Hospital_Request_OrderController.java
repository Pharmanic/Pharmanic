package com.example.pharmanic.web;

import com.example.pharmanic.model.LM_Hospital_Request_Order;
import com.example.pharmanic.model.LM_Hospital_Request_Order_Cart;
import com.example.pharmanic.repositories.LM_Hospital_Request_OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("/dhRequestOrder")
public class LM_Hospital_Request_OrderController {
    private LM_Hospital_Request_OrderRepository lm_hospital_request_orderRepository;

    public LM_Hospital_Request_OrderController(LM_Hospital_Request_OrderRepository lm_hospital_request_orderRepository) {
        super();
        this.lm_hospital_request_orderRepository = lm_hospital_request_orderRepository;
    }
    @PostMapping("/addOrder")
    ResponseEntity<LM_Hospital_Request_Order> addItem(@Validated @RequestBody LM_Hospital_Request_Order lm_hospital_request_order_cart) throws URISyntaxException {
        LM_Hospital_Request_Order result = lm_hospital_request_orderRepository.save(lm_hospital_request_order_cart);
        return ResponseEntity.created(new URI("/dhRequestOrder/addOrder" + result.getOrderId())).body(result);
    }
}
