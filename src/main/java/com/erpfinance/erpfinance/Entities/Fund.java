package com.erpfinance.erpfinance.Entities;

import com.erpfinance.erpfinance.Entities.Enumerations.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Fund {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String name;
    private boolean active;
    private Status status;
    @JsonIgnore
    @OneToMany(mappedBy = "fund")
    private List<OperationNote> operationNotes;

}
