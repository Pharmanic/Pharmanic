package com.example.pharmanic.web;

import com.example.pharmanic.model.Direct_Hospital_Request_Order;
import com.example.pharmanic.repositories.Direct_Hospital_Request_OrderRepository;
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
public class Direct_Hospital_Request_OrderController {
    private final Logger log = LoggerFactory.getLogger(Direct_Hospital_Request_OrderController.class);
    private Direct_Hospital_Request_OrderRepository direct_hospital_request_orderRepository;

    public Direct_Hospital_Request_OrderController(Direct_Hospital_Request_OrderRepository direct_hospital_request_orderRepository) {
        this.direct_hospital_request_orderRepository = direct_hospital_request_orderRepository;
    }

    @GetMapping("/directhospitalrequestorders")
    Collection<Direct_Hospital_Request_Order> directhospitalrequestorders(){
        return direct_hospital_request_orderRepository.findAll();
    }

    @GetMapping("/directhospitalrequestorder/{id}")
    ResponseEntity<?> getDirecthospitalrequestorder(@PathVariable Long order_id){
        Optional<Direct_Hospital_Request_Order> direct_hospital_request_order=direct_hospital_request_orderRepository.findById(order_id);
        return direct_hospital_request_order.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/directhospitalrequestorder")
    ResponseEntity<Direct_Hospital_Request_Order> createDirecthospitalrequestorder(@Valid @RequestBody Direct_Hospital_Request_Order direct_hospital_request_order) throws URISyntaxException{
        log.info("Request to create direct hospital request order: {} ",direct_hospital_request_order);
        Direct_Hospital_Request_Order result= direct_hospital_request_orderRepository.save(direct_hospital_request_order);
        return ResponseEntity.created(new URI("/api/directhospitalrequestorder/"+result.getOrder_id()))
                .body(result);
    }

    @DeleteMapping("/directhospitalrequestorder/{id}")
    public ResponseEntity<?> deleteDirecthospitalrequestorder(@PathVariable Long order_id){
        log.info("Request to delete direct hospital request order: {}",order_id);
        direct_hospital_request_orderRepository.deleteById(order_id);
        return ResponseEntity.ok().build();
    }

}
