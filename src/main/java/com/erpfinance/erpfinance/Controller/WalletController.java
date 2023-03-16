package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.Wallet;
import com.erpfinance.erpfinance.Services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/wallet")
@CrossOrigin(origins = "http://localhost:4200")
public class WalletController {
    @Autowired
    private WalletService walletService;
    @PostMapping("/create")
    public ResponseEntity<Wallet> createNewWallet(@RequestBody Wallet wallet){
        System.out.println(wallet.getName()+" "+wallet.getCode()+" "+wallet.getStatus());
        if(wallet==null)
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

        Wallet savedWallet=walletService.createWallet(wallet);

        return new ResponseEntity<>(savedWallet, HttpStatus.resolve(200));



    };
    @GetMapping("/all")
    public ResponseEntity<List<Wallet>> getAllWallets(){
        return new ResponseEntity<>(walletService.getWallets(), HttpStatus.resolve(200));
    }

}
