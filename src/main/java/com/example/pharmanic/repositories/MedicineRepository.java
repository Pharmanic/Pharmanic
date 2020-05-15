package com.example.pharmanic.repositories;

import com.example.pharmanic.model.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine,String> {
}
