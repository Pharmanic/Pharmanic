package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_Hospital_Request_Order_Cart;
import com.example.pharmanic.model.Rdhs_Hospital_Return_Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Rdhs_Hospital_Request_Order_CartRepository extends JpaRepository<Rdhs_Hospital_Request_Order_Cart,Long> {
    Rdhs_Hospital_Request_Order_Cart findByCartId(Long cartId);

    @Query(value="select * from Rdhs_Hospital_Request_Order_Cart where reg_no = :reg_no ",nativeQuery=true)
    List<Rdhs_Hospital_Request_Order_Cart> viewOrderCart(@Param("reg_no")String reg_no);
}
