package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MedicineRepository extends JpaRepository<Medicine,String> {
    @Query(value="select *from medicine u where sr_no = :sr_no",nativeQuery=true)
    public Medicine findBySr_no(@Param("sr_no") String sr_no);

    //remove later
    @Query(value="select *from medicine u where sr_no = :sr_no",nativeQuery=true)
    public Medicine findByname(@Param("name") String name);



    @Query(value="select count(sr_no) from medicine",nativeQuery=true)
    public Integer getMedicineCount();
}


