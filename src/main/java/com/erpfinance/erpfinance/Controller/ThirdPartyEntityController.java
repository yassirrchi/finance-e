package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/thirdpartyentity")
@CrossOrigin(origins = "http://localhost:4200")
public class ThirdPartyEntityController {
    @PostMapping("/create")
    public ResponseEntity<?> createThirdPartyEntity(@RequestBody ThirdPartyEntity thirdPartyEntity){
        System.out.println("okey "+thirdPartyEntity.getName()+thirdPartyEntity.isActive()+thirdPartyEntity.isBank()+thirdPartyEntity.isCustodian());


        return null;
    }



}
