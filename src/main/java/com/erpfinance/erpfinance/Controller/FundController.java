package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import com.erpfinance.erpfinance.Services.FundServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fund")
@CrossOrigin(origins = "http://localhost:4200")
public class FundController {
    @Autowired
    private FundServices fundServices;


    @PostMapping("/create")
    public ResponseEntity<?> createFund(@RequestBody ThirdPartyEntity thirdPartyEntity){





        return new ResponseEntity<>(null,HttpStatus.resolve(200));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllFunds(){
        return new ResponseEntity<>(fundServices.getAllFunds(),HttpStatus.resolve(200));



    }


}
