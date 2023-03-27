package com.erpfinance.erpfinance.Entities;

import com.erpfinance.erpfinance.Entities.Enumerations.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private boolean active;
    private String external_code;
    private Status status;
    private LocalDate opening_date;
    private LocalDate closing_date;
    @JsonIgnore
    @OneToMany(mappedBy = "wallet")
    private List<OperationNote> operationNotes;


}
