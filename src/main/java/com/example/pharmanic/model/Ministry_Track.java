package com.example.pharmanic.model;

import com.example.pharmanic.Ministry_Driver;
import com.example.pharmanic.Ministry_Vehicle;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.Set;

@Data
@Entity
public class Ministry_Track {
    private @Id @GeneratedValue Long track_id;

    @ManyToMany
    private Set<Ministry_Vehicle> vehicle_id;

    @ManyToMany
    private Set<Ministry_Driver> driver_id;

    private String starting_point;

    private String destination;

    private Date date;

    public Ministry_Track() {
    }

    public Ministry_Track(Set<Ministry_Vehicle> vehicle_id, Set<Ministry_Driver> driver_id, String starting_point, String destination, Date date) {
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

    public Set<Ministry_Vehicle> getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(Set<Ministry_Vehicle> vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public Set<Ministry_Driver> getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(Set<Ministry_Driver> driver_id) {
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
}
