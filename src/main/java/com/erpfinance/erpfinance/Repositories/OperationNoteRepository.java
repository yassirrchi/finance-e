package com.erpfinance.erpfinance.Repositories;

import com.erpfinance.erpfinance.Entities.OperationNote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationNoteRepository extends JpaRepository<OperationNote,Long> {
}
