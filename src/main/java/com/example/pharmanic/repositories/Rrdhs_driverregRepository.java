package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rrdhs_driverreg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Rrdhs_driverregRepository extends JpaRepository<Rrdhs_driverreg,String>{
    @Query(value = "select *from Rdhs_driverreg u where nic = :nic", nativeQuery = true)
    public Rrdhs_driverreg findByNic(@Param("nic") String nic);
}
