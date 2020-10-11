package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Rdhs_Damage_Stock {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long did;

    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Rdhs_Current_Stock id;

    @ManyToOne
    @JoinColumn(name="batch_id",referencedColumnName = "batch_id")
    private Ministry_Current_Stock batch_id;

    private Date date;
    private Long quantity;
    private String reason;
    private Long status;

    public Rdhs_Damage_Stock() {
    }

    public Rdhs_Damage_Stock(Long did, Rdhs_Current_Stock id, Ministry_Current_Stock batch_id, Date date, Long quantity, String reason, Long status) {
        this.did = did;
        this.id = id;
        this.batch_id = batch_id;
        this.date = date;
        this.quantity = quantity;
        this.reason = reason;
        this.status = status;
    }

    public Long getDid() {
        return did;
    }

    public void setDid(Long did) {
        this.did = did;
    }

    public Rdhs_Current_Stock getId() {
        return id;
    }

    public void setId(Rdhs_Current_Stock id) {
        this.id = id;
    }

    public Ministry_Current_Stock getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Ministry_Current_Stock batch_id) {
        this.batch_id = batch_id;
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

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Rdhs_Damage_Stock{" +
                "did=" + did +
                ", id=" + id +
                ", batch_id=" + batch_id +
                ", date=" + date +
                ", quantity=" + quantity +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                '}';
    }
}
