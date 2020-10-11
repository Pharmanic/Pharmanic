package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Supply_Order_To_Rdhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Supply_Order_To_RdhsRepository extends JpaRepository<Supply_Order_To_Rdhs,Long> {
    @Query(value="{call close_rdhsreq_order(:o_id)}",nativeQuery=true)
    public void closeRdhsReqOrder(@Param("o_id") Long o_id);


    @Query(value="{call set_orders_to_pending_rdhs(:o_id)}",nativeQuery=true)
    public void setorderstopending(@Param("o_id") Long o_id);

    @Query(value="select count(id) from rdhs_request_order_detail u where order_id = :id and supply_status= 1",nativeQuery=true)
    public Integer suppliedcount(@Param("id")Long id);

    @Query(value="select count(id) from rdhs_request_order_detail u where order_id = :id",nativeQuery=true)
    public Integer orderdetailcont(@Param("id")Long id);
}
