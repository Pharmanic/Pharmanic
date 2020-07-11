package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Ministry_Store;
import com.example.pharmanic.model.Ministry_Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Ministry_VehicleRepository extends JpaRepository<Ministry_Vehicle,String> {

    @Query(value="select *from ministry_vehicle u where vehicle_no = :vehicle_no",nativeQuery=true)
    public Ministry_Vehicle findByVehicle_no(@Param("vehicle_no") String vehicle_no);
//remove later
    @Query(value="select *from ministry_vehicle u where vehicle_no = :vehicle_no",nativeQuery=true)
    public Ministry_Vehicle findBytype(@Param("type") String type);

}
