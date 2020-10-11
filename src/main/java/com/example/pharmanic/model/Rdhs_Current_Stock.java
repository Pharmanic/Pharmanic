package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Rdhs_Current_Stock {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name="sr_no", referencedColumnName ="sr_no")
    private Medicine sr_no;

    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Rdhs rdhs_reg_no;

    @ManyToOne
    @JoinColumn(name = "batch_id",referencedColumnName = "batch_id")
    private Ministry_Current_Stock batch_id;

    private Date expire_date;

    private Long available_quantity;

    public Rdhs_Current_Stock() {
    }

    public Rdhs_Current_Stock(Long id, Medicine sr_no, Rdhs rdhs_reg_no, Date expire_date, Long available_quantity) {

        this.id = id;
        this.sr_no = sr_no;
        this.rdhs_reg_no = rdhs_reg_no;
        this.expire_date = expire_date;
        this.available_quantity = available_quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicine getSr_no() {
        return sr_no;
    }

    public void setSr_no(Medicine sr_no) {
        this.sr_no = sr_no;
    }

    public Rdhs getRdhs_reg_no() {
        return rdhs_reg_no;
    }

    public void setRdhs_reg_no(Rdhs rdhs_reg_no) {
        this.rdhs_reg_no = rdhs_reg_no;
    }

    public Date getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(Date expire_date) {
        this.expire_date = expire_date;
    }

    public Long getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(Long available_quantity) {
        this.available_quantity = available_quantity;
    }

    @Override
    public String toString() {
        return "Rdhs_Current_Stock{" +
                "id=" + id +
                ", sr_no=" + sr_no +
                ", rdhs_reg_no=" + rdhs_reg_no +
                ", expire_date=" + expire_date +
                ", available_quantity=" + available_quantity +
                '}';
    }
}
