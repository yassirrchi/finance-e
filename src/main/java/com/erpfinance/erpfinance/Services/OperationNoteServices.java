package com.erpfinance.erpfinance.Services;

import com.erpfinance.erpfinance.Entities.OperationNote;
import com.erpfinance.erpfinance.Requests.OperationNoteRequest;

import java.util.List;
import java.util.Optional;

public interface OperationNoteServices {
    public OperationNote createOperationNote(OperationNoteRequest operationNoteRequest);
    public List<OperationNote> getAllOperationNotes();
    public Optional<OperationNote> getOperationNoteById(Long id);

}
