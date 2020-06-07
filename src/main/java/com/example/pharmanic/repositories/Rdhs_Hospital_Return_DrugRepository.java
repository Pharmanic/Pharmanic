package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.model.Rdhs_Hospital_Return_Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface Rdhs_Hospital_Return_DrugRepository extends JpaRepository<Rdhs_Hospital_Return_Drug,Long> {
  //  insert into rdhs_hospital_return_drug (date,quantity,state,reg_no,batch_id) Values('2020-05-30',12,0,'RH001',12);
    @Query(value="select * from Rdhs_Hospital_Current_Stock h where h.reg_no = :reg_no order by expiredate ASC ",nativeQuery=true)
    List<Rdhs_Hospital_Current_Stock> findByreg_noOrderByexpiredateAsc(@Param("reg_no")String reg_no);

}
