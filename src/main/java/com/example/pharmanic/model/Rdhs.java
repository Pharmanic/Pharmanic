package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@Entity
public class Rdhs {
    private @Id String reg_no;

    private String name;
    private String address;
    private String email;
    private String telephone;


    public Rdhs() {
    }



    public Rdhs(String reg_no, String name, String address, String email, String telephone) {
        this.reg_no = reg_no;
        this.name = name;
        this.address = address;
        this.email = email;
        this.telephone = telephone;
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



    @Override
    public String toString() {
        return "Rdhs{" +
                "reg_no='" + reg_no + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +

                '}';
    }
}
