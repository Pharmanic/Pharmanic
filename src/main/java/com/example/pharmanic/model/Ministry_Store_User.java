package com.example.pharmanic.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Ministry_Store_User extends User {
/*
    @ManyToOne
    @JoinColumn(name = "m_store_id",referencedColumnName = "m_store_id")
    private Ministry_Store ministry_store;


    public Ministry_Store_User() {

    }

    public Ministry_Store_User(String nic, String first_name, String last_name, String tel_no, String email, String address, String password, Integer status, Integer role, Ministry_Store ministry_store) {
        super(nic, first_name, last_name, tel_no, email, address, password, status, role);
        this.ministry_store = ministry_store;
    }

    public Ministry_Store getMinistry_store() {
        return ministry_store;
    }

    public void setMinistry_store(Ministry_Store ministry_store) {
        this.ministry_store = ministry_store;
    }

    @Override
    public String toString() {
        return "Ministry_Store_User{" +
                "ministry_store=" + ministry_store +
                '}';
    }

 */
}