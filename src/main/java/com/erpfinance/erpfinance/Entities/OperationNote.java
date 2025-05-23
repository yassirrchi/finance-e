package com.erpfinance.erpfinance.Entities;

import com.erpfinance.erpfinance.Entities.Enumerations.OperationType;
import com.erpfinance.erpfinance.Entities.Enumerations.Status;
import com.erpfinance.erpfinance.Entities.Enumerations.ThirdPartyType;
import com.erpfinance.erpfinance.Entities.UserAndRoles.User;
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
    private int quantity;
    private int price;
    private OperationType type;
    private Status status;
    private int gross_amount;
    private LocalDate op_date;
    private LocalDate val_date;
    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;
    @ManyToOne
    @JoinColumn(name = "fund_id")
    private Fund fund;
    @ElementCollection


    private List<ThirdPartyEntity> thirdPartyEntities;
    @ManyToOne
    private User createdby;









}
