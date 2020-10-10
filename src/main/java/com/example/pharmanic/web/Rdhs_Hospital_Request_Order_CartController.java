package com.example.pharmanic.web;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.model.Rdhs_Hospital_Request_Order_Cart;
import com.example.pharmanic.model.Rdhs_Hospital_Return_Drug;
import com.example.pharmanic.repositories.Rdhs_Hospital_Request_Order_CartRepository;
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
@RequestMapping("/rhRequestOrder")
public class Rdhs_Hospital_Request_Order_CartController {
    private Rdhs_Hospital_Request_Order_CartRepository rdhs_hospital_request_order_cartRepository;

    public Rdhs_Hospital_Request_Order_CartController(Rdhs_Hospital_Request_Order_CartRepository rdhs_hospital_request_order_cartRepository) {
        super();
        this.rdhs_hospital_request_order_cartRepository = rdhs_hospital_request_order_cartRepository;
    }
    @GetMapping("/getOrderCart")
    Collection<Rdhs_Hospital_Request_Order_Cart> rdhs_hospital_request_order_carts(){
        return rdhs_hospital_request_order_cartRepository.findAll();
    }
    @GetMapping("/cartOrder/{id}")
    ResponseEntity<?> getOrderCart(@PathVariable Long id) {
        Optional<Rdhs_Hospital_Request_Order_Cart> rdhs_hospital_request_order_cart = Optional.ofNullable(rdhs_hospital_request_order_cartRepository.findByCartId(id));
        return rdhs_hospital_request_order_cart.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addToOrderCart")
    ResponseEntity<Rdhs_Hospital_Request_Order_Cart> addItem(@Validated @RequestBody Rdhs_Hospital_Request_Order_Cart rdhs_hospital_request_order_cart) throws URISyntaxException {
        System.out.println("POST"+rdhs_hospital_request_order_cart);
        Rdhs_Hospital_Request_Order_Cart result = rdhs_hospital_request_order_cartRepository.save(rdhs_hospital_request_order_cart);
        return ResponseEntity.created(new URI("/rhRequestOrder/addToOrderCart" + result.getCartId())).body(result);
    }


    @PutMapping("/updateCart/{id}")
    ResponseEntity<Rdhs_Hospital_Request_Order_Cart> updateExpense(@Validated @RequestBody Rdhs_Hospital_Request_Order_Cart rdhs_hospital_request_order_cart) {
        System.out.println("In update");
       // System.out.println({id});
        Rdhs_Hospital_Request_Order_Cart result = rdhs_hospital_request_order_cartRepository.save(rdhs_hospital_request_order_cart);
        return ResponseEntity.ok().body(result);
    }
    @RequestMapping(value = "/viewcart/{reg_no}", method = RequestMethod.GET)
    List<Rdhs_Hospital_Request_Order_Cart> getOrderCart(@PathVariable("reg_no") String reg_no) {
        return rdhs_hospital_request_order_cartRepository.viewOrderCart(reg_no);

    }

    @DeleteMapping("/deleteCartItem/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable Long id) {
        rdhs_hospital_request_order_cartRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
