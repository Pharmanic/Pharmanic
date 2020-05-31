package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import com.example.pharmanic.model.Rdhs_Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Rdhs_TrackRepository extends JpaRepository<Rdhs_Track,Long> {
    @Query(value="select * from Rdhs_Hospital_Current_Stock h where h.reg_no = :reg_no order by expiredate ASC ",nativeQuery=true)
    List<Rdhs_Hospital_Current_Stock> findByreg_noOrderByexpiredateAsc(@Param("reg_no")String reg_no);

    @Query(value = "select returned_id from rdhs_hospital_return_drug  order by returned_id desc limit 1",nativeQuery = true)
    String findNextId();

}
