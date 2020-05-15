package com.example.pharmanic.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
public class Ministry_Track {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long track_id;

    @ManyToOne
    @JoinColumn(name = "vehicle_no",referencedColumnName = "vehicle_no")
    private Ministry_Vehicle vehicle_id;

    @ManyToOne
    @JoinColumn(name = "nic",referencedColumnName = "nic")
    private Ministry_Driver driver_id;

    private String starting_point;
    private String destination;
    private Date date;

    public Ministry_Track() {
    }

    public Ministry_Track(Long track_id, Ministry_Vehicle vehicle_id, Ministry_Driver driver_id, String starting_point, String destination, Date date) {
        this.track_id = track_id;
        this.vehicle_id = vehicle_id;
        this.driver_id = driver_id;
        this.starting_point = starting_point;
        this.destination = destination;
        this.date = date;
    }

    public Long getTrack_id() {
        return track_id;
    }

    public void setTrack_id(Long track_id) {
        this.track_id = track_id;
    }

    public Ministry_Vehicle getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Ministry_Vehicle vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public Ministry_Driver getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Ministry_Driver driver_id) {
        this.driver_id = driver_id;
    }

    public String getStarting_point() {
        return starting_point;
    }

    public void setStarting_point(String starting_point) {
        this.starting_point = starting_point;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ministry_Track{" +
                "track_id=" + track_id +
                ", vehicle_id=" + vehicle_id +
                ", driver_id=" + driver_id +
                ", starting_point='" + starting_point + '\'' +
                ", destination='" + destination + '\'' +
                ", date=" + date +
                '}';
    }
}
