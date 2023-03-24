package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fund")
@CrossOrigin(origins = "http://localhost:4200")
public class FundController {
    @PostMapping("/create")
    public ResponseEntity<?> createFund(@RequestBody ThirdPartyEntity thirdPartyEntity){





        return new ResponseEntity<>(null,HttpStatus.resolve(200));
    }


}
