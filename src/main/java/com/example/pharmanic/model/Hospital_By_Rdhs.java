package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

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
    @ManyToOne
    @JoinColumn(name = "rdhs_id",referencedColumnName = "reg_no")
    private Rdhs rdhs;

    public Hospital_By_Rdhs() {
    }

    public Hospital_By_Rdhs(String reg_no, String name, String address, String telephone, String email, String doctor_incharge, Rdhs rdhs) {
        this.reg_no = reg_no;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
        this.doctor_incharge = doctor_incharge;
        this.rdhs = rdhs;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDoctor_incharge() {
        return doctor_incharge;
    }

    public void setDoctor_incharge(String doctor_incharge) {
        this.doctor_incharge = doctor_incharge;
    }

    public Rdhs getRdhs() {
        return rdhs;
    }

    public void setRdhs(Rdhs rdhs) {
        this.rdhs = rdhs;
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
                ", rdhs=" + rdhs +
                '}';
    }
}
