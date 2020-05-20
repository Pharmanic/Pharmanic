package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Hospital_By_Rdhs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Hospital_By_RdhsRepository extends JpaRepository<Hospital_By_Rdhs,String> {

    @Query(value="select * from hospital_by_rdhs h where reg_no = :reg_no",nativeQuery=true)
    public Hospital_By_Rdhs findByReg_no(@Param("reg_no")String reg_no);

}
