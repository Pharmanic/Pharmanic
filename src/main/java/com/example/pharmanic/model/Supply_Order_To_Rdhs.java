package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Supply_Order_To_Rdhs {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long supply_id;

    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Rdhs_Request_Order_Detail request_id;

    @ManyToOne
    @JoinColumn(name = "track_id",referencedColumnName = "track_id")
    private Ministry_Track track_id;

    public Supply_Order_To_Rdhs() {
    }

    public Supply_Order_To_Rdhs(Long supply_id, Rdhs_Request_Order_Detail request_id, Ministry_Track track_id) {
        this.supply_id = supply_id;
        this.request_id = request_id;
        this.track_id = track_id;
    }

    public Long getSupply_id() {
        return supply_id;
    }

    public void setSupply_id(Long supply_id) {
        this.supply_id = supply_id;
    }

    public Rdhs_Request_Order_Detail getRequest_id() {
        return request_id;
    }

    public void setRequest_id(Rdhs_Request_Order_Detail request_id) {
        this.request_id = request_id;
    }

    public Ministry_Track getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Ministry_Track track_id) {
        this.track_id = track_id;
    }

    @Override
    public String toString() {
        return "Supply_Order_To_Rdhs{" +
                "supply_id=" + supply_id +
                ", request_id=" + request_id +
                ", track_id=" + track_id +
                '}';
    }
}
