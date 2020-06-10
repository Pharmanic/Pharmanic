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



    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "reg_no",referencedColumnName = "reg_no",nullable=true)
    private Rdhs reg_no;


   @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "vehicle_no",referencedColumnName = "vehicle_no",nullable=true)
    private Rdhs_Vehicle vehicle_no;


    @ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name = "nic",referencedColumnName = "nic",nullable=true)
    private Rdhs_Driver nic;



}
