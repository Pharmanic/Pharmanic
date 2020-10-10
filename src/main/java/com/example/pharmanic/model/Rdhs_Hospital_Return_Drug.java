package com.example.pharmanic.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Rdhs_Hospital_Return_Drug")
public class Rdhs_Hospital_Return_Drug {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long returnedId;
    private Date date;
    private int quantity;
    private int state;
   // private int track_id;

    @ManyToOne
   @JoinColumn(name = "reg_no", referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;



 /*   @ManyToOne
    @JoinColumn(name = "track_id" ,referencedColumnName = "track_id")
    private Rdhs_Track track_id;*/

    @ManyToOne
    @JoinColumn(name = "stockId" ,referencedColumnName = "stockId")
    private Rdhs_Hospital_Current_Stock rdhs_hospital_current_stock;

   @Column(nullable = true)
    private Long track_id;



}
