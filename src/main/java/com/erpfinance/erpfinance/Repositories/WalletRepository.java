package com.erpfinance.erpfinance.Repositories;

import com.erpfinance.erpfinance.Entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {
}
