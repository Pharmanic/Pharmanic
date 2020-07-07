package com.example.pharmanic.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Table(name = "Rdhs_Hospital_Issued_Drugs")
public class Rdhs_Hospital_Issued_Drugs {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long issueId;
    private String Date;
    private Integer qty;

    @ManyToOne
    @JoinColumn(name = "reg_no", referencedColumnName = "reg_no")
    private Hospital_By_Rdhs hospital_by_rdhs;

    private Long stockId;

}
