package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.Wallet;
import com.erpfinance.erpfinance.Repositories.WalletRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {
    @Autowired
    private WalletRepository walletRepository;
    @Override
    public Wallet createWallet(Wallet wallet) {

        Wallet newWallet=new Wallet();
        newWallet.setName(wallet.getName());
        newWallet.setCode(wallet.getCode());
        newWallet.setExternal_code(wallet.getExternal_code());
        newWallet.setStatus(wallet.getStatus());

        //other details






        return walletRepository.save(newWallet);
    }
}
