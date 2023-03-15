package com.erpfinance.erpfinance.Entities.UserAndRoles;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Role_Name;

    //section authorities
    private boolean create;
    private boolean edit;
    private boolean delete;






}
