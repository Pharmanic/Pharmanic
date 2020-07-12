package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_driverreg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Rdhs_driverregRepository extends JpaRepository<Rdhs_driverreg,String>{
    @Query(value = "select *from Rdhs_driverreg u where nic = :nic", nativeQuery = true)
    public Rdhs_driverreg findByNic(@Param("nic") String nic);
}
