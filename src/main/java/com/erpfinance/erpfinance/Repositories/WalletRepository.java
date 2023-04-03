package com.erpfinance.erpfinance.Repositories;

import com.erpfinance.erpfinance.Entities.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

Wallet findWalletById(Long id);

}
