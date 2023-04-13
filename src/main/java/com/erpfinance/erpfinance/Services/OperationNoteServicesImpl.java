package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.Enumerations.OperationType;
import com.erpfinance.erpfinance.Entities.Enumerations.Status;
import com.erpfinance.erpfinance.Entities.Fund;
import com.erpfinance.erpfinance.Entities.OperationNote;
import com.erpfinance.erpfinance.Entities.Ticket;
import com.erpfinance.erpfinance.Repositories.*;
import com.erpfinance.erpfinance.Requests.OperationNoteRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
public class OperationNoteServicesImpl implements OperationNoteServices {
    @Autowired
    private OperationNoteRepository operationNoteRepository;
    @Autowired
    private FundRepository fundRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private WalletRepository walletRepository;
    @Override
    public OperationNote createOperationNote(OperationNoteRequest operationNoteRequest) {

        OperationNote newOperationNote=new OperationNote();
        if(operationNoteRequest.getFundid()!=null) {





            newOperationNote.setFund(fundRepository.findFundById(operationNoteRequest.getFundid()));

        }
        if(operationNoteRequest.getCreatedby()!=null) {





            newOperationNote.setCreatedby(userRepository.findUserById(operationNoteRequest.getCreatedby()));

        }
        if(operationNoteRequest.getWalletid()!=null) {





            newOperationNote.setWallet(walletRepository.findWalletById(operationNoteRequest.getWalletid()));

        }
        newOperationNote.setQuantity(operationNoteRequest.getQuantity());
        newOperationNote.setPrice(operationNoteRequest.getPrice());
        newOperationNote.setGross_amount(operationNoteRequest.getGamount());
        newOperationNote.setType(operationNoteRequest.getOp_type()==0? OperationType.BUY_EQUITY:OperationType.SELL_EQUITY);
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy-MM-dd");
        newOperationNote.setOp_date(LocalDate.parse(operationNoteRequest.getOp_date(), dtf));
        newOperationNote.setVal_date(LocalDate.parse(operationNoteRequest.getVal_date(), dtf));

        newOperationNote.setStatus(operationNoteRequest.getStatus()==0? Status.DRAFT:Status.SUBMIT);
        Ticket ticket=new Ticket();
        ticket.setTestMessage(newOperationNote.getCreatedby().getUsername()+" a cree une operation");
        ticketRepository.save(ticket);











        return operationNoteRepository.save(newOperationNote);
    }

    @Override
    public List<OperationNote> getAllOperationNotes() {
        return operationNoteRepository.findAll();
    }

    @Override
    public Optional<OperationNote> getOperationNoteById(Long id) {
        return  operationNoteRepository.findById(id);
    }
}
