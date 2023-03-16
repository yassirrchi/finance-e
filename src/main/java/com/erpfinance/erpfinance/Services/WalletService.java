package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.Wallet;

import java.util.List;

public interface WalletService {
    public Wallet createWallet(Wallet wallet);
    public List<Wallet> getWallets();
}
