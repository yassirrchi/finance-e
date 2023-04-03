package com.erpfinance.erpfinance.Entities.UserAndRoles;

import com.erpfinance.erpfinance.Entities.OperationNote;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @JsonIgnore
    @OneToMany(mappedBy = "createdby")

    private List<OperationNote> operationNoteList;







}
