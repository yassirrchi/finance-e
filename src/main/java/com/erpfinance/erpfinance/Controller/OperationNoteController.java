package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import com.erpfinance.erpfinance.Repositories.OperationNoteRepository;
import com.erpfinance.erpfinance.Requests.OperationNoteRequest;
import com.erpfinance.erpfinance.Services.OperationNoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/operationnote")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationNoteController {

    @Autowired
    private OperationNoteServices operationNoteServices;
    @GetMapping("/all")
    public ResponseEntity<?> getAllOperationNotes(){

        return new ResponseEntity<>(operationNoteServices.getAllOperationNotes(),HttpStatus.resolve(200));
    }
    @PostMapping("/create")
    public ResponseEntity<?> createOperationNote(@RequestBody OperationNoteRequest operationNoteRequest){
        System.out.println(operationNoteRequest.getOp_date()+" "+operationNoteRequest.getVal_date()+" "+operationNoteRequest.getStatus()+" "+operationNoteRequest.getOp_type());

        //System.out.println(operationNoteRequest.getCreatedby()+"<= user / fundid=> "+operationNoteRequest.getFundid()+" quantity=>"+operationNoteRequest.getQuantity()+" price=>"+operationNoteRequest.getPrice()+" walletid=>"+operationNoteRequest.getWalletid()+" status=>"+operationNoteRequest.getStatus());
        return new ResponseEntity<>(operationNoteServices.createOperationNote(operationNoteRequest),HttpStatus.resolve(200));

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getAllOperationNotes(@PathVariable Long id){

        return new ResponseEntity<>(operationNoteServices.getOperationNoteById(id),HttpStatus.resolve(200));
    }

}
