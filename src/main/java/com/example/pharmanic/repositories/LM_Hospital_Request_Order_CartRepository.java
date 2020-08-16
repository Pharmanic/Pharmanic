package com.example.pharmanic.repositories;

import com.example.pharmanic.model.LM_Hospital_Request_Order_Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LM_Hospital_Request_Order_CartRepository extends JpaRepository<LM_Hospital_Request_Order_Cart,Long> {
    LM_Hospital_Request_Order_Cart findByCartId(Long cartId);

    @Query(value="select * from LM_Hospital_Request_Order_Cart where reg_no = :reg_no ",nativeQuery=true)
    List<LM_Hospital_Request_Order_Cart> viewOrderCart(@Param("reg_no")String reg_no);
}
