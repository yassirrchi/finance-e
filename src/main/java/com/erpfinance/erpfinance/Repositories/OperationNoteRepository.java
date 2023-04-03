package com.erpfinance.erpfinance.Repositories;

import com.erpfinance.erpfinance.Entities.OperationNote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationNoteRepository extends JpaRepository<OperationNote,Long> {




}
