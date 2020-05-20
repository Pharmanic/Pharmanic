package com.example.pharmanic.model;

import jdk.jfr.Enabled;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Enabled
public class Direct_Hospital_Return_Drug {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @ManyToOne
    @JoinColumn(name = "dh_reg_no", referencedColumnName = "reg_no")
    private Direct_Hospital dh_reg_no;

    @ManyToOne
    @JoinColumn(name = "sr_no", referencedColumnName = "sr_no")
    private Medicine sr_no;

    @ManyToOne
    @JoinColumn(name = "track_id", referencedColumnName = "track_id")
    private Ministry_Track track_id;

    private Date date;
    private String drug_name;
    private Long quantity;

    public Direct_Hospital_Return_Drug() {
    }

    public Direct_Hospital_Return_Drug(Long id, Direct_Hospital dh_reg_no, Medicine sr_no, Ministry_Track track_id, Date date, String drug_name, Long quantity) {
        this.id = id;
        this.dh_reg_no = dh_reg_no;
        this.sr_no = sr_no;
        this.track_id = track_id;
        this.date = date;
        this.drug_name = drug_name;
        this.quantity = quantity;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public Direct_Hospital getDH_reg_no() { return dh_reg_no; }

    public void setDH_reg_no(Direct_Hospital dh_reg_no) { this.dh_reg_no = dh_reg_no; }

    public Medicine getSr_no() { return sr_no; }

    public void setSr_no(Medicine sr_no) { this.sr_no = sr_no; }

    public Ministry_Track getTrack_id() { return track_id; }

    public void setTrack_id(Ministry_Track track_id) { this.track_id = track_id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }

    public String getDrug_name() { return drug_name; }

    public void setDrug_name(String drug_name) { this.drug_name = drug_name; }

    public Long getQuantity() { return quantity; }

    public void setQuantity(Long quantity) { this.quantity = quantity; }

    @Override
    public String toString() {
        return "Direct_Hospital_Return_Drug{" +
                "id=" + id +
                ", dh_reg_no=" + dh_reg_no +
                ", sr_no=" + sr_no +
                ", drug_name'" + drug_name + '\'' +
                ", track_id=" + track_id +
                ", date=" + date +
                ", quantity=" + quantity +
                '}';
    }
}
