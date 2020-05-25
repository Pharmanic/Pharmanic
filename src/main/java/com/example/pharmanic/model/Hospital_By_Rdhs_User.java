package com.example.pharmanic.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Hospital_By_Rdhs_User extends User {
/*
    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;


    public Hospital_By_Rdhs_User() {

    }

    public Hospital_By_Rdhs_User(String nic, String first_name, String last_name, String tel_no, String email, String address, String password, Integer status, Integer role, Hospital_By_Rdhs hospital_by_rdhs) {
        super(nic, first_name, last_name, tel_no, email, address, password, status, role);
        this.hospital_by_rdhs = hospital_by_rdhs;
    }

    public Hospital_By_Rdhs getHospital_by_rdhs() {
        return hospital_by_rdhs;
    }

    public void setHospital_by_rdhs(Hospital_By_Rdhs hospital_by_rdhs) {
        this.hospital_by_rdhs = hospital_by_rdhs;
    }

    @Override
    public String toString() {
        return "Hospital_By_Rdhs_User{" +
                "hospital_by_rdhs=" + hospital_by_rdhs +
                '}';
    }

 */
}