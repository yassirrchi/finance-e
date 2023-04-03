package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.Fund;
import com.erpfinance.erpfinance.Entities.OperationNote;
import com.erpfinance.erpfinance.Repositories.FundRepository;
import com.erpfinance.erpfinance.Repositories.OperationNoteRepository;
import com.erpfinance.erpfinance.Repositories.UserRepository;
import com.erpfinance.erpfinance.Repositories.WalletRepository;
import com.erpfinance.erpfinance.Requests.OperationNoteRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
