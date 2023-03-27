package com.erpfinance.erpfinance.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationNoteRequest {
    private Long fundid;
    private Long counterid;
    private Long walletid;
    private Long status;
    private Long quantity;
    private Long price;
    private Long gamount;
    private Long typeop;
    private Long custodianid;
    private LocalDate value_date;



}
