package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import com.erpfinance.erpfinance.Repositories.ThirdPartyEntityRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional

public class ThirdPartyEntityServicesImpl implements ThirdPartyEntityServices {
    @Autowired

    private ThirdPartyEntityRepository thirdPartyEntityRepository;

    @Override
    public ThirdPartyEntity createThirdPartyEntity(ThirdPartyEntity thirdPartyEntity) {
        if(thirdPartyEntity==null)
            return null;
        ThirdPartyEntity newthirdPartyEntity=new ThirdPartyEntity();
        newthirdPartyEntity.setCode(thirdPartyEntity.getCode());
        newthirdPartyEntity.setName(thirdPartyEntity.getName());
        newthirdPartyEntity.setBank(thirdPartyEntity.isBank());
        newthirdPartyEntity.setCustodian(thirdPartyEntity.isCustodian());
        newthirdPartyEntity.setCounterparty(thirdPartyEntity.isCounterparty());


        return thirdPartyEntityRepository.save(newthirdPartyEntity);
    }

    @Override
    public List<ThirdPartyEntity> getAllThirdPartyEntity() {
        return thirdPartyEntityRepository.findAll();
    }
}
