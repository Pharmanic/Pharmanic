package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Supply_Order_To_Direct_Hospital {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long supply_id;

    @OneToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Direct_Hospital_Request_Order_Detail request_id;

    @ManyToOne
    @JoinColumn(name = "track_id",referencedColumnName = "track_id")
    private Ministry_Track track_id;

    private Date supply_date;
    private int status;
    private Date confirm_date;

    public Supply_Order_To_Direct_Hospital() {
    }

    public Supply_Order_To_Direct_Hospital(Long supply_id, Direct_Hospital_Request_Order_Detail request_id, Ministry_Track track_id, Date supply_date, int status, Date confirm_date) {
        this.supply_id = supply_id;
        this.request_id = request_id;
        this.track_id = track_id;
        this.supply_date = supply_date;
        this.status = status;
        this.confirm_date = confirm_date;
    }

    public Long getSupply_id() {
        return supply_id;
    }

    public void setSupply_id(Long supply_id) {
        this.supply_id = supply_id;
    }

    public Direct_Hospital_Request_Order_Detail getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Direct_Hospital_Request_Order_Detail request_id) {
        this.request_id = request_id;
    }

    public Ministry_Track getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Ministry_Track track_id) {
        this.track_id = track_id;
    }

    public Date getSupply_date() {
        return supply_date;
    }

    public void setSupply_date(Date supply_date) {
        this.supply_date = supply_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getConfirm_date() {
        return confirm_date;
    }

    public void setConfirm_date(Date confirm_date) {
        this.confirm_date = confirm_date;
    }

    @Override
    public String toString() {
        return "Supply_Order_To_Direct_Hospital{" +
                "supply_id=" + supply_id +
                ", request_id=" + request_id +
                ", track_id=" + track_id +
                ", supply_date=" + supply_date +
                ", status=" + status +
                ", confirm_date=" + confirm_date +
                '}';
    }
}
