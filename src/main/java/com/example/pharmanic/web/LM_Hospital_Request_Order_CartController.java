package com.example.pharmanic.web;

import com.example.pharmanic.model.LM_Hospital_Current_Stock;
import com.example.pharmanic.model.LM_Hospital_Request_Order_Cart;
import com.example.pharmanic.repositories.LM_Hospital_Request_Order_CartRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dhRequestOrder")
public class LM_Hospital_Request_Order_CartController {
    private LM_Hospital_Request_Order_CartRepository lm_hospital_request_order_cartRepository;

    public LM_Hospital_Request_Order_CartController(LM_Hospital_Request_Order_CartRepository lm_hospital_request_order_cartRepository) {
        super();
        this.lm_hospital_request_order_cartRepository = lm_hospital_request_order_cartRepository;
    }
    @GetMapping("/getOrderCart")
    Collection<LM_Hospital_Request_Order_Cart> lm_hospital_request_order_carts(){
        return lm_hospital_request_order_cartRepository.findAll();
    }
    @GetMapping("/cartOrder/{id}")
    ResponseEntity<?> getOrderCart(@PathVariable Long id) {
        Optional<LM_Hospital_Request_Order_Cart> lm_hospital_request_order_cart = Optional.ofNullable(lm_hospital_request_order_cartRepository.findByCartId(id));
        return lm_hospital_request_order_cart.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addToOrderCart")
    ResponseEntity<LM_Hospital_Request_Order_Cart> addItem(@Validated @RequestBody LM_Hospital_Request_Order_Cart lm_hospital_request_order_cart) throws URISyntaxException {
        System.out.println("POST"+lm_hospital_request_order_cart);
        LM_Hospital_Request_Order_Cart result = lm_hospital_request_order_cartRepository.save(lm_hospital_request_order_cart);
        return ResponseEntity.created(new URI("/dhRequestOrder/addToOrderCart" + result.getCartId())).body(result);
    }


    @PutMapping("/updateCart/{id}")
    ResponseEntity<LM_Hospital_Request_Order_Cart> updateExpense(@Validated @RequestBody LM_Hospital_Request_Order_Cart lm_hospital_request_order_cart) {
        System.out.println("In update");
        LM_Hospital_Request_Order_Cart result = lm_hospital_request_order_cartRepository.save(lm_hospital_request_order_cart);
        return ResponseEntity.ok().body(result);
    }
    @RequestMapping(value = "/viewcart/{reg_no}", method = RequestMethod.GET)
    List<LM_Hospital_Request_Order_Cart> getOrderCart(@PathVariable("reg_no") String reg_no) {
        return lm_hospital_request_order_cartRepository.viewOrderCart(reg_no);

    }

    @DeleteMapping("/deleteCartItem/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        lm_hospital_request_order_cartRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
