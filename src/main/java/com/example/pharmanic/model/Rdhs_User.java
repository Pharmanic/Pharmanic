package com.example.pharmanic.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Rdhs_User extends User {

    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Rdhs rdhs;


    public Rdhs_User() {

    }

    public Rdhs_User(String nic, String first_name, String last_name, String tel_no, String email, String address, String password, Integer status, Integer role, Rdhs rdhs) {
        super(nic, first_name, last_name, tel_no, email, address, password, status, role);
        this.rdhs = rdhs;
    }

    public Rdhs getRdhs() {
        return rdhs;
    }

    public void setRdhs(Rdhs rdhs) {
        this.rdhs = rdhs;
    }

    @Override
    public String toString() {
        return "Rdhs_User{" +
                "rdhs=" + rdhs +
                '}';
    }
}