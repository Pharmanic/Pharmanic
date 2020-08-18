package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
public class Direct_Hospital_Current_Stock {

    @Id
    @GeneratedValue
    private Long id;

    private @GeneratedValue(strategy = GenerationType.IDENTITY) Long batch_id;

    @ManyToOne
    @JoinColumn(name = "sr_no", referencedColumnName = "sr_no")
    private Medicine sr_no;

    @ManyToOne
    @JoinColumn(name = "dh_reg_no", referencedColumnName = "reg_no")
    private Direct_Hospital dh_reg_no;

    private Date expire_date;
    private String name;
    private Long available_quantity;

    public Direct_Hospital_Current_Stock() {
    }

    public Direct_Hospital_Current_Stock(Long id, Long batch_id, Medicine sr_no, String name, Date expire_date, Long available_quantity, Direct_Hospital dh_reg_no) {
        this.id = id;
        this.batch_id = batch_id;
        this.sr_no = sr_no;
        this.name = name;
        this.expire_date = expire_date;
        this.available_quantity = available_quantity;
        this.dh_reg_no = dh_reg_no;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Long getBatch_id() { return batch_id; }

    public void setBatch_id(Long batch_id) { this.batch_id = batch_id; }

    public Medicine getSr_no() { return sr_no; }

    public void setSr_no(Medicine sr_no) { this.sr_no = sr_no; }

    public Date getExpire_date() { return expire_date; }

    public void setExpire_date(Date expire_date) { this.expire_date = expire_date; }

    public Long getAvailable_quantity() { return available_quantity; }

    public void setAvailable_quantity(Long available_quantity) { this.available_quantity = available_quantity; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Direct_Hospital getDH_reg_no() { return dh_reg_no; }

    public void setDG_reg_no(Direct_Hospital dg_reg_no) { this.dh_reg_no = dg_reg_no; }

    @Override
    public String toString() {
        return "Direct_Hospital_Current_Stock{" +
                "id=" + id +
                "batch_id=" + batch_id +
                ", sr_no=" + sr_no +
                ", name='" + name + '\'' +
                ", expire_date=" + expire_date +
                ", available_quantity=" + available_quantity +
                ", dh_reg_no=" + dh_reg_no +
                '}';
    }
}
