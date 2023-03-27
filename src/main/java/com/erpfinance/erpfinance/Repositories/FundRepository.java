package com.erpfinance.erpfinance.Repositories;

import com.erpfinance.erpfinance.Entities.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FundRepository extends JpaRepository<Fund,Long> {
    Fund findFundById(Long id);

}
