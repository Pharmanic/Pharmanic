package com.example.pharmanic.model;

import com.example.pharmanic.Medicine;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Supply_Order_Detail_To_Direct_Hospital {

    private @Id @GeneratedValue Long id;

    @ManyToMany
    private Set<Supply_Order_To_Direct_Hospital> order_id;

    @ManyToMany
    private Set<Medicine> sr_no;

    private String drug_name;
    private Long quantity;
    private Date date;

    public Supply_Order_Detail_To_Direct_Hospital() {
    }

    public Supply_Order_Detail_To_Direct_Hospital(Set<Supply_Order_To_Direct_Hospital> order_id, Set<Medicine> sr_no, String drug_name, Long quantity, Date date) {
        this.order_id = order_id;
        this.sr_no = sr_no;
        this.drug_name = drug_name;
        this.quantity = quantity;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Supply_Order_To_Direct_Hospital> getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Set<Supply_Order_To_Direct_Hospital> order_id) {
        this.order_id = order_id;
    }

    public Set<Medicine> getSr_no() {
        return sr_no;
    }

    public void setSr_no(Set<Medicine> sr_no) {
        this.sr_no = sr_no;
    }

    public String getDrug_name() {
        return drug_name;
    }

    public void setDrug_name(String drug_name) {
        this.drug_name = drug_name;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
