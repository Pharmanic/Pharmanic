package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Hospital_By_Rdhs")
public class Hospital_By_Rdhs {
    private @Id String reg_no;
    private String name;
    private String address;
    private String telephone;
    private String email;
    private String doctor_incharge;
    private String rdhsId;

    public Hospital_By_Rdhs() {
    }

    public Hospital_By_Rdhs(String reg_no, String name, String address, String telephone, String email, String doctor_incharge, String rdhsId) {
        this.reg_no = reg_no;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.doctor_incharge = doctor_incharge;
        this.rdhsId = rdhsId;
    }

    public String getRdhsId() {
        return rdhsId;
    }

    public void setRdhsId(String rdhsId) {
        this.rdhsId = rdhsId;
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
        return "Hospital_By_Rdhs{" +
                "reg_no='" + reg_no + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", doctor_incharge='" + doctor_incharge + '\'' +
                ", rdhsId='" + rdhsId + '\'' +
                '}';
    }
}
