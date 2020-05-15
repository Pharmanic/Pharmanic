package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Supply_Order_To_Direct_Hospital {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long order_id;

    @OneToOne
    @JoinColumn(name = "order_id",referencedColumnName = "order_id")
    private Direct_Hospital_Request_Order request_id;

    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Direct_Hospital direct_hospital_reg_no;

    @ManyToOne
    @JoinColumn(name = "track_id",referencedColumnName = "track_id")
    private Ministry_Track track_id;

    public Supply_Order_To_Direct_Hospital() {
    }

    public Supply_Order_To_Direct_Hospital(Long order_id, Direct_Hospital_Request_Order request_id, Direct_Hospital direct_hospital_reg_no, Ministry_Track track_id) {
        this.order_id = order_id;
        this.request_id = request_id;
        this.direct_hospital_reg_no = direct_hospital_reg_no;
        this.track_id = track_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Direct_Hospital_Request_Order getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Direct_Hospital_Request_Order request_id) {
        this.request_id = request_id;
    }

    public Direct_Hospital getDirect_hospital_reg_no() {
        return direct_hospital_reg_no;
    }

    public void setDirect_hospital_reg_no(Direct_Hospital direct_hospital_reg_no) {
        this.direct_hospital_reg_no = direct_hospital_reg_no;
    }

    public Ministry_Track getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Ministry_Track track_id) {
        this.track_id = track_id;
    }

    @Override
    public String toString() {
        return "Supply_Order_To_Direct_Hospital{" +
                "order_id=" + order_id +
                ", request_id=" + request_id +
                ", direct_hospital_reg_no=" + direct_hospital_reg_no +
                ", track_id=" + track_id +
                '}';
    }
}
