package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Direct_Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Direct_HospitalRepository extends JpaRepository<Direct_Hospital,String> {

    @Query(value="select * from direct_hospital u where reg_no = :reg_no",nativeQuery=true)
    public Direct_Hospital findByReg_no(@Param("reg_no")String reg_no);
}
