package com.erpfinance.erpfinance.Controller;

import com.erpfinance.erpfinance.Repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/tickets")
@CrossOrigin(origins = "http://localhost:4200")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;
    @GetMapping("/all")
    public ResponseEntity<?> getAllFunds(){
        return new ResponseEntity<>(ticketRepository.findAll(), HttpStatus.resolve(200));
    }


}
