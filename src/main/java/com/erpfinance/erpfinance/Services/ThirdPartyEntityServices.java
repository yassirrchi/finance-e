package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;

import java.util.List;

public interface ThirdPartyEntityServices {
    public ThirdPartyEntity createThirdPartyEntity(ThirdPartyEntity thirdPartyEntity);
    public List<ThirdPartyEntity> getAllThirdPartyEntity();
}
