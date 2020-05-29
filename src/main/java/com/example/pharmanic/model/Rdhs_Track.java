package com.example.pharmanic.model;

import javax.persistence.*;
import java.util.Date;

public class Rdhs_Track {
    @Id
   // @GeneratedValue(strategy = GenerationType.AUTO)
    private int track_id;
    private Date date;
    private String start_point;
    private String end_point;


    @ManyToOne
    @JoinColumn(name = "reg_no", nullable = false, referencedColumnName = "reg_no")
    private Rdhs rdhs;

    @ManyToOne
    @JoinColumn(name = "vehicle_no", nullable = false, referencedColumnName = "vehicle_no")
    private Rdhs_Vehicle rdhs_vehicle;

    @ManyToOne
    @JoinColumn(name = "nic", nullable = false, referencedColumnName = "nic")
    private Rdhs_Driver rdhs_driver;



}
