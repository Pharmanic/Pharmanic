package com.example.pharmanic.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Direct_Hospital_User extends User {

    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Direct_Hospital direct_hospital;

    public Direct_Hospital_User() {

    }

    public Direct_Hospital_User(Long nic, String first_name, String last_name, String tel_no, String email, String address, String password, Integer status, Integer role, Direct_Hospital direct_hospital) {
        super(nic, first_name, last_name, tel_no, email, address, password, status, role);
        this.direct_hospital = direct_hospital;
    }

    public Direct_Hospital getDirect_hospital() {
        return direct_hospital;
    }

    public void setDirect_hospital(Direct_Hospital direct_hospital) {
        this.direct_hospital = direct_hospital;
    }

    @Override
    public String toString() {
        return "Direct_Hospital_User{" +
                "direct_hospital=" + direct_hospital +
                '}';
    }
}