package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Direct_Hospital {
    private @Id String reg_no;

    private String name;
    private String address;
    private String email;
    private String telephone;
    private String doctor_incharge;

    public Direct_Hospital() {
    }

    public Direct_Hospital(String reg_no, String name, String address, String email, String telephone, String doctor_incharge) {
        this.reg_no = reg_no;
        this.name = name;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
        this.doctor_incharge = doctor_incharge;
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDoctor_incharge() {
        return doctor_incharge;
    }

    public void setDoctor_incharge(String doctor_incharge) {
        this.doctor_incharge = doctor_incharge;
    }

    @Override
    public String toString() {
        return "Direct_Hospital{" +
                "reg_no='" + reg_no + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", doctor_incharge='" + doctor_incharge + '\'' +
                '}';
    }
}
