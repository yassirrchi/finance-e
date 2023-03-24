package com.erpfinance.erpfinance.Requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationNoteRequest {
    private Long fundId;
    private Long counterPartyAccountId;

    private Long interbankId;
    private Long custodianId;
    private LocalDate value_date;



}
