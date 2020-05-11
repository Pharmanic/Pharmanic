package com.example.pharmanic.model;

import com.example.pharmanic.Rdhs;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.Set;

@Data
@Entity
public class Supply_Order_To_Rdhs {
    private @Id @GeneratedValue Long order_id;

    @ManyToMany
    private Set<Rdhs_Request_Order> request_id;

    @ManyToMany
    private Set<Rdhs> rdhs_reg_no;

    @ManyToMany
    private Set<Ministry_Track> track_id;

    public Supply_Order_To_Rdhs() {
    }

    public Supply_Order_To_Rdhs(Set<Rdhs_Request_Order> request_id, Set<Rdhs> rdhs_reg_no, Set<Ministry_Track> track_id) {
        this.request_id = request_id;
        this.rdhs_reg_no = rdhs_reg_no;
        this.track_id = track_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Set<Rdhs_Request_Order> getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Set<Rdhs_Request_Order> request_id) {
        this.request_id = request_id;
    }

    public Set<Rdhs> getRdhs_reg_no() {
        return rdhs_reg_no;
    }

    public void setRdhs_reg_no(Set<Rdhs> rdhs_reg_no) {
        this.rdhs_reg_no = rdhs_reg_no;
    }

    public Set<Ministry_Track> getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Set<Ministry_Track> track_id) {
        this.track_id = track_id;
    }
}
