package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.Fund;
import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;

import java.util.List;

public interface FundServices {
    public Fund createFund(Fund fund);
    public List<Fund> getAllFunds();

}
