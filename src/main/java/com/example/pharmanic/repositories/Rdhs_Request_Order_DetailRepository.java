package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital_Request_Order_Detail;
import com.example.pharmanic.model.Rdhs_Request_Order_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Rdhs_Request_Order_DetailRepository extends JpaRepository<Rdhs_Request_Order_Detail,Long> {

    @Query(value="{call rdhsreq_order_details(:id)}",nativeQuery=true)
    public List<Rdhs_Request_Order_Detail> selectreqorderdetails(@Param("id") Long id);

    @Query(value="{call dhreq_order_details(:id)}",nativeQuery=true)
    public List<Direct_Hospital_Request_Order_Detail> rdhsreqorderdetail(@Param("id") Long id);

    @Query(value="{call can_supply_stock_rdhs(:o_id, :m_id, :x, :med_id)}",nativeQuery=true)
    public Integer cansullpyorder(@Param("o_id") Long o_id,@Param("m_id") Long m_id, @Param("x") Long x,@Param("med_id") String med_id);

    @Query(value="{call supply_orders_to_rdhs(:o_d_id, :x, :med, :m_s_id)}",nativeQuery=true)
    public Integer sypplyordersrdhs(@Param("o_d_id") Long o_d_id,@Param("x") Long x,@Param("med") String med,@Param("m_s_id") Long m_s_id);

    @Query(value="select * from rdhs_request_order_detail u where id = :id",nativeQuery=true)
    public Rdhs_Request_Order_Detail findByID(@Param("id")Long id);
}
