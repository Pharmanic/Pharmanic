package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Medicine;
import com.example.pharmanic.model.Ministry_Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ministry_DriverRepository extends JpaRepository<Ministry_Driver,String> {

    @Query(value="select *from ministry_driver u where nic = :nic",nativeQuery=true)
    public Ministry_Driver findByNic(@Param("nic") String nic);

}
