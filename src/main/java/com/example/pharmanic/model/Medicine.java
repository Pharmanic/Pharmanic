package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class  Medicine {
    private @Id String sr_no;

    private String name;
    private String side_effect;
    private String description;
    //remove later
    private String country;

    public Medicine() {
    }

    public Medicine(String sr_no, String name, String side_effect, String description) {
        this.sr_no = sr_no;
        this.name = name;
        this.side_effect = side_effect;
        this.description = description;
    }

    public String getSr_no() {
        return sr_no;
    }

    public void setSr_no(String sr_no) {
        this.sr_no = sr_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSide_effect() {
        return side_effect;
    }

    public void setSide_effect(String side_effect) {
        this.side_effect = side_effect;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "sr_no='" + sr_no + '\'' +
                ", name='" + name + '\'' +
                ", side_effect='" + side_effect + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
