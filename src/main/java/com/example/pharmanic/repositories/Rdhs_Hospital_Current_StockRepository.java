package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface Rdhs_Hospital_Current_StockRepository extends JpaRepository<Rdhs_Hospital_Current_Stock,Long> {
 Rdhs_Hospital_Current_Stock findByStockId(Long id);

 @Query(value="select * from Rdhs_Hospital_Current_Stock h where h.sr_no = :sr_no",nativeQuery=true)
 List<Rdhs_Hospital_Current_Stock> findBySr_no(@Param("sr_no")String sr_no);

 @Query(value="select * from Rdhs_Hospital_Current_Stock h where h.reg_no = :reg_no",nativeQuery=true)
 List<Rdhs_Hospital_Current_Stock> findByreg_no(@Param("reg_no")String reg_no);

 //List<Rdhs_Hospital_Current_Stock> \ = repository.findAll(Sort.by(Sort.Direction.ASC, "seatNumber"));


 //List<Rdhs_Hospital_Current_Stock> findByBatchIdOrderByExpiredateAsc(String expiredate);
 @Query(value="select * from Rdhs_Hospital_Current_Stock h where h.reg_no = :reg_no order by expiredate ASC ",nativeQuery=true)
 List<Rdhs_Hospital_Current_Stock> findByreg_noOrderByexpiredateAsc(@Param("reg_no")String reg_no);

 @Query(value = "select stock_id,batch_no,expiredate,reg_no,sr_no,sum(quantity) as quantity from Rdhs_Hospital_Current_Stock h where h.reg_no = :reg_no group by sr_no order by quantity ASC",nativeQuery = true)
 List<Rdhs_Hospital_Current_Stock> findByreg_noQuantityAsc(@Param("reg_no")String reg_no);
/*
 @Query(value ="select  sr_no,sum(quantity) from Rdhs_Hospital_Current_Stock h where h.reg_no = :reg_no group by sr_no");
 //@Query(value = "select * from rdhs_hospital_current_stock h  where h.reg_no=:reg_no group by sr_no",nativeQuery = true);
 List<Rdhs_Hospital_Current_Stock> findByqty(@Param("reg_no")String reg_no);
*/
}
