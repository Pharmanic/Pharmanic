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
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long returned_id;
    private Date date;
    private int quantity;
    private int state;
   // private int track_id;

    @ManyToOne
   @JoinColumn(name = "reg_no", referencedColumnName = "reg_no")
    private Hospital_By_Rdhs reg_no;

    @ManyToOne
    @JoinColumn(name = "batchId" ,referencedColumnName = "batchId")
    private Rdhs_Hospital_Current_Stock batchId;

    @Column(nullable = false)
    private Long track_id;

}
