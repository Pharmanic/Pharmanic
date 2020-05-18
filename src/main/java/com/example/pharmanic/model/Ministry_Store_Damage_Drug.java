package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Ministry_Store_Damage_Drug {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long did;

    @ManyToOne
    @JoinColumn(name = "batch_id",referencedColumnName = "batch_id")
    private Ministry_Current_Stock batch_id;

    private Date date;
    private Long quantity;
    private String reason;

    public Ministry_Store_Damage_Drug() {
    }

    public Ministry_Store_Damage_Drug(Long did, Ministry_Current_Stock batch_id, Date date, Long quantity, String reason) {
        this.did = did;
        this.batch_id = batch_id;
        this.date = date;
        this.quantity = quantity;
        this.reason = reason;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Ministry_Current_Stock getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Ministry_Current_Stock batch_id) {
        this.batch_id = batch_id;
    }

    @Override
    public String toString() {
        return "Ministry_Store_Damage_Drug{" +
                "did=" + did +
                ", batch_id=" + batch_id +
                ", date=" + date +
                ", quantity=" + quantity +
                ", reason='" + reason + '\'' +
                '}';
    }
}
