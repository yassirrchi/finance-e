package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Entities.ThirdPartyEntity;
import com.erpfinance.erpfinance.Repositories.OperationNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/operationnote")
@CrossOrigin(origins = "http://localhost:4200")
public class OperationNoteController {
    @Autowired
    private OperationNoteRepository operationNoteRepository;
    @GetMapping("/all")
    public ResponseEntity<?> getAllOperationNotes(){





        return new ResponseEntity<>(operationNoteRepository.findAll(),HttpStatus.resolve(200));
    }
}
