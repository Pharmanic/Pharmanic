package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_Hospital_Request_Order_Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Rdhs_Hospital_Request_Order_CartRepository extends JpaRepository<Rdhs_Hospital_Request_Order_Cart,Long> {
    Rdhs_Hospital_Request_Order_Cart findByCartId(Long cartId);
}
