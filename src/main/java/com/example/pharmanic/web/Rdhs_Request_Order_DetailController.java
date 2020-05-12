package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Request_Order_Detail;
import com.example.pharmanic.repositories.Rdhs_Request_Order_DetailRepository;
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
public class Rdhs_Request_Order_DetailController {
    private final Logger log= LoggerFactory.getLogger(Rdhs_Request_Order_DetailController.class);
    private Rdhs_Request_Order_DetailRepository rdhs_request_order_detailRepository;

    public Rdhs_Request_Order_DetailController(Rdhs_Request_Order_DetailRepository rdhs_request_order_detailRepository) {
        this.rdhs_request_order_detailRepository = rdhs_request_order_detailRepository;
    }

    @GetMapping("/rdhsrequestorderdetails")
    Collection<Rdhs_Request_Order_Detail> rdhsrequestorderdetails(){
        return rdhs_request_order_detailRepository.findAll();
    }

    @GetMapping("/rdhsrequestorderdetail/{id}")
    ResponseEntity<?> getdRhsrequestorderdetail(@PathVariable Long id){
        Optional<Rdhs_Request_Order_Detail> rdhs_request_order_detail=rdhs_request_order_detailRepository.findById(id);
        return rdhs_request_order_detail.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/rdhsrequestorderdetail")
    ResponseEntity<Rdhs_Request_Order_Detail> createRdhsrequestorderdetail(@Valid @RequestBody Rdhs_Request_Order_Detail rdhs_request_order_detail)throws URISyntaxException{
        log.info("Request to create RDHS request to order detail:{}",rdhs_request_order_detail);
        Rdhs_Request_Order_Detail result=rdhs_request_order_detailRepository.save(rdhs_request_order_detail);
        return ResponseEntity.created(new URI("/api/rdhsrequestorderdetail/"+result.getId()))
                .body(result);
    }

    @DeleteMapping("/rdhsrequestorderdetail/{id}")
    public ResponseEntity<?> deleteRdhsrequestorderdetail(@PathVariable Long id){
        log.info("Request to delete RDHS request order detail: {}",id);
        rdhs_request_order_detailRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
