package com.erpfinance.erpfinance.Entities;

import com.erpfinance.erpfinance.Entities.Enumerations.Status;
import com.erpfinance.erpfinance.Entities.Enumerations.ThirdPartyType;
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
public class ThirdPartyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String name;
    private boolean active;
    private String external_code;
    private Status status;
    private LocalDate opening_date;
    private LocalDate closing_date;
    private boolean bank;
    private boolean counterparty;
    private boolean custodian;



    @ElementCollection(targetClass = ThirdPartyType.class)
    private List<ThirdPartyType> type;



}
