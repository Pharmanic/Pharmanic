package com.example.pharmanic;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Ministry_Store {
    private @Id @GeneratedValue Long m_store_id;

    private String location;

    public Ministry_Store() {
    }

    public Ministry_Store(String location) {
        this.location = location;
    }

    public Long getM_store_id() {
        return m_store_id;
    }

    public void setM_store_id(Long m_store_id) {
        this.m_store_id = m_store_id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
