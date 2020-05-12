package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Request_Order;
import com.example.pharmanic.repositories.Rdhs_Request_OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class Rdhs_Request_OrderController {
    private final Logger log = LoggerFactory.getLogger(Rdhs_Request_OrderController.class);
    private Rdhs_Request_OrderRepository rdhs_request_orderRepository;

    public Rdhs_Request_OrderController(Rdhs_Request_OrderRepository rdhs_request_orderRepository) {
        this.rdhs_request_orderRepository = rdhs_request_orderRepository;
    }

    @GetMapping("/rdhsrequestorders")
    Collection<Rdhs_Request_Order> rdhsrequestorders(){
        return rdhs_request_orderRepository.findAll();
    }

    @GetMapping("/rdhsrequestorder/{id}")
    ResponseEntity<?> getRdhsrequestorder(@PathVariable Long order_id){
        Optional<Rdhs_Request_Order> rdhs_request_order = rdhs_request_orderRepository.findById(order_id);
        return rdhs_request_order.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/rdhsrequestorder")
    ResponseEntity<Rdhs_Request_Order> createRdhsrequestorder(@Valid @RequestBody Rdhs_Request_Order rdhs_request_order) throws URISyntaxException{
        log.info("Request to create RDHS request order: {}",rdhs_request_order);
        Rdhs_Request_Order result = rdhs_request_orderRepository.save(rdhs_request_order);
        return ResponseEntity.created(new URI("/api/rdhsrequestorder/"+result.getOrder_id()))
                .body(result);
    }

    @DeleteMapping("/rdhsrequestorder/{id}")
    public ResponseEntity<?> deleteRdhsrequestorder(@PathVariable Long order_id){
        log.info("Request to delete RDHS request order: {} ",order_id);
        rdhs_request_orderRepository.deleteById(order_id);
        return ResponseEntity.ok().build();
    }
}
