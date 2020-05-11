package com.example.pharmanic.model;

import com.example.pharmanic.Direct_Hospital;
import lombok.Data;
import lombok.Generated;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Supply_Order_To_Direct_Hospital {
    private @Id @GeneratedValue Long order_id;

    @ManyToMany
    private Set<Direct_Hospital_Request_Order> request_id;

    @ManyToMany
    private Set<Direct_Hospital> direct_hospital_reg_no;

    @ManyToMany
    private Set<Ministry_Track> track_id;

    public Supply_Order_To_Direct_Hospital() {
    }

    public Supply_Order_To_Direct_Hospital(Set<Direct_Hospital_Request_Order> request_id, Set<Direct_Hospital> direct_hospital_reg_no, Set<Ministry_Track> track_id) {
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

    public Set<Direct_Hospital_Request_Order> getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Set<Direct_Hospital_Request_Order> request_id) {
        this.request_id = request_id;
    }

    public Set<Direct_Hospital> getDirect_hospital_reg_no() {
        return direct_hospital_reg_no;
    }

    public void setDirect_hospital_reg_no(Set<Direct_Hospital> direct_hospital_reg_no) {
        this.direct_hospital_reg_no = direct_hospital_reg_no;
    }

    public Set<Ministry_Track> getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Set<Ministry_Track> track_id) {
        this.track_id = track_id;
    }
}
