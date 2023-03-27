package com.erpfinance.erpfinance.Entities;

import com.erpfinance.erpfinance.Entities.Enumerations.ThirdPartyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OperationNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @ManyToOne
    @JoinColumn(name = "fund_id")
    private Fund fund;
    @ElementCollection


    private List<ThirdPartyEntity> thirdPartyEntities;









}
