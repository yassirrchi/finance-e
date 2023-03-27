package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.Fund;
import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import com.erpfinance.erpfinance.Repositories.FundRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Transactional

public class FundServicesImpl implements FundServices {
    @Autowired
    private FundRepository fundRepository;

    @Override
    public Fund createFund(Fund fund) {
        return null;
    }

    @Override
    public List<Fund> getAllFunds() {
        return fundRepository.findAll();
    }
}
