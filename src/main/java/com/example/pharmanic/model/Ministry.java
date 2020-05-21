package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Ministry {
    private @Id String ministry_id;

    public Ministry() {
    }

    public Ministry(String ministry_id) {
        this.ministry_id = ministry_id;
    }

    public String getMinistry_id() {
        return ministry_id;
    }

    public void setMinistry_id(String ministry_id) {
        this.ministry_id = ministry_id;
    }

    @Override
    public String toString() {
        return "Ministry{" +
                "ministry_id='" + ministry_id + '\'' +
                '}';
    }
}
