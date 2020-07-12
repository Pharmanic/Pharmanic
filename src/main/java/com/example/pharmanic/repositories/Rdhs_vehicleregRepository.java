package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Rdhs_vehiclereg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface Rdhs_vehicleregRepository extends JpaRepository<Rdhs_vehiclereg,String> {
    @Query(value = "select *from Rdhs_vehiclereg u where vehicle_no = :vehicle_no", nativeQuery = true)
    public Rdhs_vehiclereg findByVehicle_no(@Param("vehicle_no") String vehicle_no);
}
