package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;

import java.util.List;

public interface FundServices {
    public ThirdPartyEntity createThirdPartyEntity(ThirdPartyEntity thirdPartyEntity);
    public List<ThirdPartyEntity> getAllThirdPartyEntity();

}
