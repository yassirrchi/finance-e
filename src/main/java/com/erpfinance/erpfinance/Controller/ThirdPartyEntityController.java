package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import com.erpfinance.erpfinance.Repositories.ThirdPartyEntityRepository;
import com.erpfinance.erpfinance.Services.ThirdPartyEntityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/thirdpartyentity")
@CrossOrigin(origins = "http://localhost:4200")
public class ThirdPartyEntityController {
    @Autowired
    private ThirdPartyEntityServices thirdPartyEntityServices;
    @PostMapping("/create")
    public ResponseEntity<?> createThirdPartyEntity(@RequestBody ThirdPartyEntity thirdPartyEntity){
        System.out.println("okey "+thirdPartyEntity.getName()+thirdPartyEntity.isCounterparty()+thirdPartyEntity.isBank()+thirdPartyEntity.isCustodian());
        ThirdPartyEntity thirdParty=thirdPartyEntityServices.createThirdPartyEntity(thirdPartyEntity);
                if(thirdParty==null)
                    return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(thirdParty,HttpStatus.resolve(200));
    }
    @GetMapping("/all")
    public ResponseEntity<?> getAllThirdPartyEntites(){
        List<ThirdPartyEntity> allThirdParties;
        allThirdParties=thirdPartyEntityServices.getAllThirdPartyEntity();
        return new ResponseEntity<>(allThirdParties,HttpStatus.resolve(200));

    }



}
