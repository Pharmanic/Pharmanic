package com.example.pharmanic.model;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Rdhs_order_medicine {
    private @Id String sr_no;
    private String name;
    private String quantity;

    public Rdhs_order_medicine() {
    }

    public Rdhs_order_medicine(String sr_no, String name, String quantity){
        this.sr_no = sr_no;
        this.name = name;
        this.quantity = quantity;
    }

    public String getsr_no() {
        return sr_no;
    }

    public void setsr_no(String sr_no) {
        this.sr_no = sr_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getquantity() {
        return quantity;
    }

    public void setquantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Rdhs_order_medicine{" +
                "sr_no='" + sr_no + '\'' +
                ", name='" + name + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
