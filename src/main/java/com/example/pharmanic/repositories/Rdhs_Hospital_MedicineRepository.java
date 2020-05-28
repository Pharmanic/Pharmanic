package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Hospital_By_Rdhs;
import com.example.pharmanic.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Rdhs_Hospital_MedicineRepository extends JpaRepository<Medicine,String> {

    @Query(value="select * from Medicine h where h.sr_no = :sr_no",nativeQuery=true)
    Medicine findBySr_no(@Param("sr_no")String sr_no);
}
