package com.example.pharmanic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no",nullable=false)
    private Rdhs reg_no;


   @ManyToOne
    @JoinColumn(name = "vehicle_no",referencedColumnName = "vehicle_no",nullable=false)
    private Rdhs_Vehicle vehicle_no;


    @ManyToOne
    @JoinColumn(name = "nic",referencedColumnName = "nic",nullable=false)
    private Rdhs_Driver nic;



}
