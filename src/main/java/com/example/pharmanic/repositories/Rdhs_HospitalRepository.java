package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.model.Rdhs_Hospital_Current_Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Rdhs_HospitalRepository extends JpaRepository<Hospital_By_Rdhs,String> {
    @Query(value="select * from Hospital_By_Rdhs h where h.reg_no = :reg_no",nativeQuery=true)
    Hospital_By_Rdhs findByreg_no(@Param("reg_no")String reg_no);
}
