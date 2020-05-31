package com.example.pharmanic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Rdhs_Track")
public class Rdhs_Track {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long track_id;
    private String date;
    private String start_point;
    private String end_point;


    @ManyToOne
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no")
    private Rdhs rdhs;


    @ManyToOne
    @JoinColumn(name = "vehicle_no",referencedColumnName = "vehicle_no")
    private Rdhs_Vehicle rdhs_vehicle;


    @ManyToOne
    @JoinColumn(name = "nic",referencedColumnName = "nic")
    private Rdhs_Driver rdhs_driver;



}
