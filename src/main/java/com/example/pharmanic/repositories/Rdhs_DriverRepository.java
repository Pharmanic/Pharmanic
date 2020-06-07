package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.model.Rdhs_Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Rdhs_DriverRepository extends JpaRepository<Rdhs_Driver,String> {
    @Query(value="select *from rdhs_driver u where nic = :nic",nativeQuery=true)
    public Rdhs_Driver findBynic(@Param("nic") String nic);
}
