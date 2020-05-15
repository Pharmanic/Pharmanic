package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Supply_Order_Detail_To_Direct_Hospital {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Supply_Order_To_Direct_Hospital order_id;

    @ManyToOne
    @JoinColumn(name = "sr_no",referencedColumnName = "sr_no")
    private Medicine sr_no;

    private String drug_name;
    private Long quantity;
    private Date date;

    public Supply_Order_Detail_To_Direct_Hospital() {
    }

    public Supply_Order_Detail_To_Direct_Hospital(Long id, Supply_Order_To_Direct_Hospital order_id, Medicine sr_no, String drug_name, Long quantity, Date date) {
        this.id = id;
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

    public Supply_Order_To_Direct_Hospital getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Supply_Order_To_Direct_Hospital order_id) {
        this.order_id = order_id;
    }

    public Medicine getSr_no() {
        return sr_no;
    }

    public void setSr_no(Medicine sr_no) {
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

    @Override
    public String toString() {
        return "Supply_Order_Detail_To_Direct_Hospital{" +
                "id=" + id +
                ", order_id=" + order_id +
                ", sr_no=" + sr_no +
                ", drug_name='" + drug_name + '\'' +
                ", quantity=" + quantity +
                ", date=" + date +
                '}';
    }
}
