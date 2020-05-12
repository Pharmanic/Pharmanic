package com.example.pharmanic.web;


import com.example.pharmanic.model.Direct_Hospital_Request_Order_Detail;
import com.example.pharmanic.repositories.Direct_Hospital_Request_Order_DetailRepository;
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
public class Direct_Hospital_Request_Order_DetailController {
    private final Logger log = LoggerFactory.getLogger(Direct_Hospital_Request_Order_DetailController.class);
    private Direct_Hospital_Request_Order_DetailRepository direct_hospital_request_order_detailRepository;

    public Direct_Hospital_Request_Order_DetailController(Direct_Hospital_Request_Order_DetailRepository direct_hospital_request_order_detailRepository) {
        this.direct_hospital_request_order_detailRepository = direct_hospital_request_order_detailRepository;
    }

    @GetMapping("/directhospitalrequestorderdetails")
    Collection<Direct_Hospital_Request_Order_Detail> directhospitalrequestorderdetails(){
        return direct_hospital_request_order_detailRepository.findAll();
    }

    @GetMapping("/directhospitalrequestorderdetail/{id}")
    ResponseEntity<?> getDirecthospitalrequestorderdetail(@PathVariable Long id){
        Optional<Direct_Hospital_Request_Order_Detail> direct_hospital_request_order_detail = direct_hospital_request_order_detailRepository.findById(id);
        return direct_hospital_request_order_detail.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/directhospitalrequestorderdetail")
    ResponseEntity<Direct_Hospital_Request_Order_Detail> createDirecthospitalrequestorderdetail(@Valid @RequestBody Direct_Hospital_Request_Order_Detail direct_hospital_request_order_detail)throws URISyntaxException{
        log.info("Request to create direct hospital request order detail: {}",direct_hospital_request_order_detail);
        Direct_Hospital_Request_Order_Detail result = direct_hospital_request_order_detailRepository.save(direct_hospital_request_order_detail);
        return ResponseEntity.created(new URI("/api/directhospitalrequestorderdetail/"+result.getId()))
                .body(result);
    }

    @DeleteMapping("/directhospitalrequestorderdetail/{id}")
    public ResponseEntity<?> deleteDirecthospitalrequestorderdetail(@PathVariable Long id){
        log.info("Request to delete direct hospital request to order detail: {}",id);
        direct_hospital_request_order_detailRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
